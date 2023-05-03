import java.util.Scanner;

import model.Customer;
import model.CustomerLinkedList;
import model.CustomerPriorityQueue;

/**************************************************************
* Name        : Vehicle Service Tracker Final Project
* Author      : Trevor Parrish
* Created     : 5/3/2023
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program creates Customer objects. The user can enter customers and they will be added to a Linked List and Priority Queue.
* 				The user can also remove customers, view a list of customers, sort the list of customers, and view the next customer on the priority queue.
*               Input: User inputs numbers depending on what they want to do. They can also enter customer information to be added.
*               Output: GUI that shows the main menu, sub menus, a customer entry form, list of customers, and next customer in the queue.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/

public class StartProgram {
	
	// create Scanner, LinkedList, and PriorityQueue variables
	static Scanner in = new Scanner(System.in);
	static CustomerLinkedList customerList = new CustomerLinkedList();
	static CustomerPriorityQueue priorityQueue = new CustomerPriorityQueue();

	// method for the main run menu
	public static void runMenu() {
		
		boolean goAgain = true;
		
		// print introduction
		System.out.println("                  ______");
		System.out.println("                 /|_||_\\`.__");
		System.out.println("                (   _    _ _\\");
		System.out.println("                =`-(_)--(_)-'");
		System.out.println("--- Welcome to the Vehicle Service Tracker! ---");
		
		while (goAgain) {
			
			// show options menu 
			System.out.println("\n--- Main Menu ---");
			System.out.println("Select an item:");
			System.out.println("1 - Add a Customer");
			System.out.println("2 - Remove a Customer");
			System.out.println("3 - View and Sort Customer List");
			System.out.println("4 - View Next Customer in Queue");
			System.out.println("5 - Exit program");
			
			// get user selection
			System.out.print("Your Selection: ");
			int selection = in.nextInt();
			in.nextLine();
			
			// validate input for selection
			while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5) {
				System.out.print("Invalid input! Please try again: ");
				selection = in.nextInt();
				in.nextLine();
			}
			
			// run specific method depending on user selection
			if (selection == 1) {
				addCustomer();
			} else if (selection == 2) {
				removeCustomer();
			} else if (selection == 3) {
				if (customerList.isEmpty()) {
					System.out.println("\nCustomer list is empty!");
				} else {
				sortList();
				}
			} else if (selection == 4) {
				viewSchedule();
			} else {
				// quit program
				System.out.println("\n   Goodbye!   ");
				goAgain = false;
				System.exit(0);
			}
		}
	}
	
	// method that adds a Customer to the Linked List and Priority Queue
	private static void addCustomer() {
		
		// start customer entry form
		System.out.println("\n--- Customer Entry Form ---");
		
		// get name and validate input
		System.out.print("Enter Name: ");
		String name = in.nextLine();
		name = validString(name);
		
		// get phone and validate input
		System.out.print("Enter Phone # (e.g. 555-555-5555): ");
		String phone = in.nextLine();
		phone = validPhone(phone);
		
		// get car year and validate input
		System.out.print("Enter Vehicle Year: ");
		String year = in.nextLine();
		year = validYear(year);
		
		// get car make and validate input
		System.out.print("Enter Vehicle Make: ");
		String make = in.nextLine();
		make = validString(make);
		
		// get car model. No input validation since car models can have many different characters (e.g. F-150)
		System.out.print("Enter Vehicle Model: ");
		String model = in.nextLine();
		
		// show options for available services
		System.out.println("\nCodes for Services:");
		System.out.println("1 - Oil Change");
		System.out.println("2 - Tire Rotation");
		System.out.println("3 - Brakes Changed");
		System.out.println("4 - Tires Changed");
		
		// get specific code for what service is needed
		System.out.print("Enter Code for Service Needed: ");
		int serviceNeeded = in.nextInt();
		in.nextLine();
		
		// validate input for service code
		while (serviceNeeded != 1 && serviceNeeded != 2 && serviceNeeded != 3 && serviceNeeded != 4) {
			System.out.print("Invalid input! Please try again: ");
			serviceNeeded = in.nextInt();
			in.nextLine();
		}
		Customer customer = new Customer(name, phone, year, make, model, serviceNeeded);
		customerList.add(customer);
		priorityQueue.add(customer);
		
		System.out.println("Customer added!");
	}
	
	// method that deletes an item from the Priority Queue
	private static void removeCustomer() {
		
		if (priorityQueue.peek() == null) {
			System.out.println("No more Customers!");
			return;
		} else {
			System.out.println("\n" + priorityQueue.remove() + " has been removed!");
			System.out.println("\nNext Customer:");
			if (priorityQueue.peek() == null) {
				System.out.println("No more Customers!");
				return;
			} else {
				System.out.println(priorityQueue.peek());
			}
		}
	}
	
	// method for viewing and sorting the Linked List
	private static void sortList() {
		System.out.println("\n--- Customer List --- ");
		System.out.println(customerList.printList());
		
		System.out.println("\nHow would you like to sort the customer list? ");
		System.out.println("1 - Customer Name");
		System.out.println("2 - Service Needed");
		System.out.println("3 - Go Back to Main Menu");
		System.out.print("Your Selection: ");
		int selection = in.nextInt();
		in.nextLine();
		
		while (selection != 1 && selection != 2 && selection != 3) {
			System.out.print("Invalid input! Please try again: ");
			selection = in.nextInt();
			in.nextLine();
		}
		
		// call correct Insertion Sort depending on what user input is
		if (selection == 1) {
			customerList.insertionSortByName();
		} else if (selection == 2) {
			customerList.insertionSortByServiceNeeded();
		} else {
			return;
		}
		System.out.println("\n--- Sorted Customer List --- ");
		System.out.println(customerList.printList());
		
		return;
	}
	
	// method that prints the Linked List
	private static void viewSchedule() {
		System.out.println("\nNext Customer:");
		System.out.println(priorityQueue.peek());
	}
	
	// method that checks if a String only contains letters and whitespace. Also allows some characters that might be needed in a name (e.g. O'Brian)
	private static String validString(String s) {
		
		while (!s.matches("^[\\p{L} .'-]+$")) {
			System.out.print("Invalid input! Please try again: ");
			s = in.nextLine();
		}
		
		return s;
	}
	
	// method that checks if a String contains a valid phone number. 10 digits total, separated by dashes where necessary.
	private static String validPhone(String s) {
		while (!s.matches("^\\d{3}-\\d{3}-\\d{4}$")) {
			System.out.print("Invalid input! Please try again: ");
			s = in.nextLine();
		}
		return s;
	}
	
	// method that checks if a year String contains only 4 digits.
	private static String validYear(String s) {
		while (!s.matches("\\d{4}")) {
			System.out.print("Invalid input! Please try again: ");
			s = in.nextLine();
		}
		return s;
	}

	public static void main(String[] args) {
		
		// Customers to be added when the program starts. Helps with testing since there will already be entries to use, instead of adding several yourself.
		Customer customer1 = new Customer("Jane", "515-555-4567", "2022", "Jeep", "Wrangler", 2);
		Customer customer2 = new Customer("John", "515-987-6543", "2017", "Ford", "Mustang", 4);
		Customer customer3 = new Customer("Katherine", "515-138-5132", "2015", "Ford", "Focus", 3);
		Customer customer4 = new Customer("David", "515-830-6875", "2010", "Ford", "F-150", 3);
		Customer customer5 = new Customer("Emma", "515-298-8534", "2016", "Nissan", "Altima", 1);
		
		// add Customers to Linked List
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		customerList.add(customer4);
		customerList.add(customer5);
		
		// add Customers to Priority Queue
		priorityQueue.add(customer1);
		priorityQueue.add(customer2);
		priorityQueue.add(customer3);
		priorityQueue.add(customer4);
		priorityQueue.add(customer5);
		
		runMenu();
	}
}
