package model;

/**
 * This class is for creating a Linked List for Customer objects. It includes a Node and size variable and a nested Node class. 
 * It includes methods for add, size, isEmpty, get, remove, printing the list, and two methods for Insertion Sorting
 * @author Trevor Parrish
 * @version 1.0
 */

public class CustomerLinkedList {
	
	// head variable that points to the first Node in the Linked List
	private Node head;
    private int size;

    // constructor
    public CustomerLinkedList() {
        head = null;
        size = 0;
    }

    // nested Node class. Stores a Customer object and a reference to the next Node in the Linked List
    private class Node {
        private Customer data;
        private Node next;

        // constructor
        public Node(Customer data) {
            this.data = data;
            this.next = null;
        }
    }

    // method that adds a Customer object to the end of the Linked List
    public void add(Customer data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            } 
            current.next = newNode;
        }  
        size++;
    }

    // method that returns the size of the Linked List
    public int size() {
        return size;
    }
    
    // method that returns if the Linked List is empty
    public boolean isEmpty() {
        return head == null;
    }

    // method that returns the Customer object at the specified index
    public Customer get(int index) {
    	if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }  
    	
    	Node current = head;
        
    	for (int i = 0; i < index; i++) {
            current = current.next;
        }
    	return current.data;
    }
    
    // method that removes the Customer object at the specified index
    public Customer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        if (index == 0) {
            Customer removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        }         
        Node current = head;
       
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }       
        Customer removedData = current.next.data;
        current.next = current.next.next;
        size--;
        return removedData;
    }
    
    // method that prints the Linked List
    public String printList() {
    	StringBuilder sb = new StringBuilder();
        
        if (isEmpty()) {
        	sb.append("List is Empty!");
        	return sb.toString();
        }       
        Node current = head;
        
        while (current != null) {
            sb.append(current.data.printCustomer());
            
            if (current.next != null) {
                sb.append("\n");
            }
            current = current.next;
        }
        return sb.toString();
    }
    
    // method that uses Insertion Sorting to sort the Linked List by name
    public void insertionSortByName() {       
    	if (head == null || head.next == null) {
            return;
        }       
        Node sorted = null;
        Node current = head;
        
        while (current != null) {          
        	Node next = current.next;
            
            if (sorted == null || current.data.getName().compareTo(sorted.data.getName()) < 0) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                
                while (temp.next != null && current.data.getName().compareTo(temp.next.data.getName()) > 0) {
                    temp = temp.next;
                }           
                current.next = temp.next;
                temp.next = current;
            }           
            current = next;
        }       
        head = sorted;
    }
    
 // method that uses Insertion Sorting to sort the Linked List by serviceNeeded
    public void insertionSortByServiceNeeded() {       
    	if (head == null || head.next == null) {
            return;
        }       
        Node sorted = null;
        Node current = head;
        
        while (current != null) {          
        	Node next = current.next;
            
            if (sorted == null || current.data.getServiceNeeded() < sorted.data.getServiceNeeded()) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                
                while (temp.next != null && current.data.getServiceNeeded() > temp.next.data.getServiceNeeded()) {
                    temp = temp.next;
                }                
                current.next = temp.next;
                temp.next = current;
            }            
            current = next;
        }       
        head = sorted;
    }
}
