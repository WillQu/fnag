package willmann.sebastien.fnag;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link Company}
 */
public class CompanyTest {
	
	private Company company;

	@Before
	public void setUp() throws Exception {
		this.company = new Company();
		
		this.company.addProduct("LMUSB", new BigDecimal("20"), "Lance-missile USB");
		this.company.addProduct("MKB", new BigDecimal("200"), "Clavier mécanique");
		this.company.addProduct("T127", new BigDecimal("14.99"), "T-shirt 'no place like 127.0.0.1");
		
		this.company.addSale("Paris", "Bob", "LMUSB", 1);
		this.company.addSale("Lyon", "Alice", "MKB", 1);
		this.company.addSale("Lyon", "Alice", "T127", 2);
		this.company.addSale("Paris", "Bob", "T127", 1);
		this.company.addSale("Paris", "Chuck", "T127", 1);
	}

	@Test
	public void getTopProducts() {
		Map<Product, Integer> result = this.company.getTopProducts();
		
		assertEquals(1, result.size());
		assertTrue(result.keySet().contains(new Product("T127", new BigDecimal("20"), "Lance-missile USB")));
		assertTrue(result.values().contains(4));
	}
	
	@Test
	public void getTopSalesClerks() {
		Map<SalesClerk, BigDecimal> result = this.company.getTopSalesClerks();
		
		assertEquals(1, result.size());
		assertTrue(result.keySet().contains(new SalesClerk("Alice")));
		assertTrue(result.values().contains(new BigDecimal("229.98")));
	}

}
