package model;

/**
 * This class is for creating a Customer object. It includes several variables, constructors, getters and setters, and a print method
 * @author Trevor Parrish
 * @version 1.0
 */

public class Customer {
	
	// variables
	private String name;
	private String phone;
	private String carYear;
	private String carMake;
	private String carModel;
	private int serviceNeeded;
	
	// default no-args constructor
	public Customer() {
		super();
	}

	// all-args constructor
	public Customer(String name, String phone, String carYear, String carMake, String carModel, int serviceNeeded) {
		super();
		this.name = name;
		this.phone = phone;
		this.carYear = carYear;
		this.carMake = carMake;
		this.carModel = carModel;
		this.serviceNeeded = serviceNeeded;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getServiceNeeded() {
		return serviceNeeded;
	}

	public void setServiceNeeded(int serviceNeeded) {
		this.serviceNeeded = serviceNeeded;
	}
	
	// method that returns a String for printing a Customer. Looks a little cleaner than the toString and it shows the actual service needed and not an integer
	public String printCustomer() {		
		String service;
		
		// serviceNeeded integer is used for Insertion Sorting and the Priority Queue. This if-else creates a String that will be printed depending on the integer value of serviceNeeded. 
		if (serviceNeeded == 1) {
			service = "Oil Change";
		} else if (serviceNeeded == 2) {
			service = "Tire Rotation";
		} else if (serviceNeeded == 3) {
			service = "Brakes Changed";
		} else {
			service = "Tires Changed";
		}		
		return "Name = " + name + ", Phone = " + phone + ", Year = " + carYear + ", Make = " + carMake
				+ ", Model = " + carModel + ", Service Needed = " + service;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phone=" + phone + ", carYear=" + carYear + ", carMake=" + carMake
				+ ", carModel=" + carModel + ", serviceNeeded=" + serviceNeeded + "]";
	}
}
