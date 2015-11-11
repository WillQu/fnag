package willmann.sebastien.fnag;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Set;

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
	
	@Test
	public void readProductSet() throws IOException {
		String input = "3\n"
				+ "Foo|12.34|A test product\n"
				+ "Bar|42|Second product\n"
				+ "Baz|22.2|Another one";
		
		Set<Product> result = ProductReader.readProductSet(new BufferedReader(new StringReader(input)));
		
		assertEquals(3, result.size());
	}

}
