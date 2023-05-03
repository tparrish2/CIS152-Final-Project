package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CustomerPriorityQueue;
import model.Customer;

/**
 * This is a JUnit test case for testing the PriorityQueue class.
 * @author Trevor Parrish
 * @version 1.0
 */

class CustomerPriorityQueueTest {

	@Test
    public void testCustomerPriorityQueue() {
        
		CustomerPriorityQueue queue = new CustomerPriorityQueue();
        
        Customer c1 = new Customer("Trevor", "515-298-0747", "2020", "Jeep", "Renegade", 1);
		Customer c2 = new Customer("Katherine", "712-830-1351", "2015", "Ford", "Focus", 3);
		Customer c3 = new Customer("John", "515-123-4567", "2022", "Jeep", "Wrangler", 4);
        
        queue.add(c1);
        queue.add(c2);
        queue.add(c3);
        
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 3);
        assertEquals(queue.peek(), c1);
        assertEquals(queue.remove(), c1);
        assertEquals(queue.peek(), c2);
        assertEquals(queue.remove(), c2);
        assertEquals(queue.peek(), c3);
        assertEquals(queue.remove(), c3);
        
        assertTrue(queue.isEmpty());
        assertEquals(queue.size(), 0);
    }

}
