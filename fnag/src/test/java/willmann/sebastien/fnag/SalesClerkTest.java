package willmann.sebastien.fnag;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Tests for {@link SalesClerk}
 */
public class SalesClerkTest {

	@Test
	public void computeTotalSales() {
		SalesClerk salesClerk = new SalesClerk("Jean-Jacques", null);
		
		salesClerk.addSale(new Product("ref1", new BigDecimal("1"), "desc1"), 1);
		salesClerk.addSale(new Product("ref2", new BigDecimal("2"), "desc2"), 5);
		salesClerk.addSale(new Product("ref3", new BigDecimal("3"), "desc3"), 3);
		
		assertEquals(9, salesClerk.computeTotalSales());
	}

}
