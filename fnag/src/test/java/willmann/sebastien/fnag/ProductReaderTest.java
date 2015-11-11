package willmann.sebastien.fnag;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Tests for class {@link ProductReader}
 */
public class ProductReaderTest {

	@Test
	public void readProduct() {
		String line = "Foo|12.34|A test product";
		
		Product product = ProductReader.readProduct(line);
		
		assertEquals("Foo", product.getReference());
		assertEquals(new BigDecimal("12.34"), product.getPrice());
		assertEquals("A test product", product.getDescription());
	}

}
