package willmann.sebastien.fnag;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;

/**
 * Tests for the {@link Store} class
 */
public class StoreTest {

	@Test
	public void getSalesResults() {
		Product[] products = new Product[3];
		products[0] = new Product("ref1", new BigDecimal("4.2"), "desc1");
		products[1] = new Product("ref2", new BigDecimal("12.34"), "desc2");
		products[2] = new Product("ref3", new BigDecimal("234"), "desc3");
		
		Store store = new Store("Store");
		store.addRecord("Jean-Jacques", products[0], 1);
		store.addRecord("Jean-Jacques", products[1], 3);
		store.addRecord("Lucie", products[1], 2);
		store.addRecord("Lucie", products[2], 7);
		Map<Product, Integer> result = store.getSalesResults();
		
		assertEquals(1, result.get(products[0]).intValue());
		assertEquals(5, result.get(products[1]).intValue());
		assertEquals(7, result.get(products[2]).intValue());
	}

}
