package model;

/**
 * This class is for creating a Priority Queue for Customer objects. It includes a PriorityQueue variable.
 * It includes methods for add, peek, remove, isEmpty, and size.
 * @author Trevor Parrish
 * @version 1.0
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class CustomerPriorityQueue {
	
	private PriorityQueue<Customer> priorityQueue;
	
	// utilizes a Comparator that compares the serviceNeeded variable of the Customer objects. The lowest serviceNeeded value is the highest priority
    public CustomerPriorityQueue() {
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Customer::getServiceNeeded));
    }
    
    // method to add a Customer to the Priority Queue
    public void add(Customer customer) {
        priorityQueue.add(customer);
    }

    // method that returns the Customer with the highest priority
    public Customer peek() {
        return priorityQueue.peek();
    }

    // method that removes the Customer with the highest priority and returns it
    public Customer remove() {
        return priorityQueue.remove();
    }

    // method that returns if the Priority Queue is empty
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    // method that returns the size of the Priority Queue
    public int size() {
        return priorityQueue.size();
    }
}
