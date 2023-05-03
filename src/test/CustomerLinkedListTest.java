package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Customer;
import model.CustomerLinkedList;

/**
 * This is a JUnit test case for testing the LinkedList class.
 * @author Trevor Parrish
 * @version 1.0
 */

class CustomerLinkedListTest {

	@Test
    public void testCustomerLinkedList() {
		
		CustomerLinkedList cList = new CustomerLinkedList();
        
		Customer c1 = new Customer("Trevor", "515-298-0747", "2020", "Jeep", "Renegade", 1);
		Customer c2 = new Customer("Katherine", "712-830-1351", "2015", "Ford", "Focus", 3);
		Customer c3 = new Customer("John", "515-123-4567", "2022", "Jeep", "Wrangler", 4);
        
        assertTrue(cList.isEmpty());
        
        cList.add(c1);
        assertEquals(1, cList.size());
        assertFalse(cList.isEmpty());
        assertEquals(c1, cList.get(0));
        
        cList.add(c2);
        assertEquals(2, cList.size());
        assertFalse(cList.isEmpty());
        assertEquals(c1, cList.get(0));
        assertEquals(c2, cList.get(1));
        
        cList.add(c3);
        assertEquals(3, cList.size());
        assertFalse(cList.isEmpty());
        assertEquals(c1, cList.get(0));
        assertEquals(c2, cList.get(1));
        assertEquals(c3, cList.get(2));
        
        cList.remove(1);
        assertEquals(2, cList.size());
        assertFalse(cList.isEmpty());
        assertEquals(c1, cList.get(0));
        assertEquals(c3, cList.get(1));
        
        cList.remove(0);
        assertEquals(1, cList.size());
        assertFalse(cList.isEmpty());
        assertEquals(c3, cList.get(0));
        
        cList.remove(0);
        assertEquals(0, cList.size());
        assertTrue(cList.isEmpty());
    }
}
