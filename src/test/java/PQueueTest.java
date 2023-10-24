import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PQueueTest {
	
	Comparator<Customer> worth;
	Comparator<Customer> loyalty;
	Comparator<Customer> worthPolite;
	
	Customer Bradshaw = new Customer(20, 20, 1);
	Customer Bailey = new Customer(12, 3, 12);
	Customer Toth = new Customer(12, 12, 20);
	Customer Allen = new Customer(12, 12, 12);
	
	@BeforeEach
	void setUp() {
		worth = new Customer.WorthComparator();
		loyalty = new Customer.LoyaltyComparator();
		worthPolite = new Customer.WorthPoliteComparator();
	}
	
 
	@Test
	void test() {
		assertEquals(0, worth.compare(Bailey, Allen));
		assertTrue(worth.compare(Bradshaw, Allen) > 0);
		assertTrue(worth.compare(Allen, Bradshaw) < 0);
		
		assertEquals(0, loyalty.compare(Toth, Allen));
		assertTrue(loyalty.compare(Bradshaw, Allen) > 0);
		assertTrue(loyalty.compare(Allen, Bradshaw) < 0);
		
		assertEquals(0, worthPolite.compare(Bailey, Allen));
		assertTrue(worthPolite.compare(Toth, Allen) > 0);
		assertTrue(worthPolite.compare(Allen, Toth) < 0);
		assertTrue(worthPolite.compare(Bradshaw, Allen) > 0);
		assertTrue(worthPolite.compare(Allen, Bradshaw) < 0);
	}

}
