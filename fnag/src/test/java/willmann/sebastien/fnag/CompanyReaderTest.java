package willmann.sebastien.fnag;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for class {@link CompanyReader}
 */
public class CompanyReaderTest {
	
	private CompanyReader companyReader;
	
	@Before
	public void setUp() throws IOException {
		String input = "3\n"
				+ "Foo|12.34|A test product\n"
				+ "Bar|42|Second product\n"
				+ "Baz|22.2|Another one";
		
		companyReader = new CompanyReader();
		companyReader.readProductSet(new BufferedReader(new StringReader(input)));	
	}
	
	@Test
	public void readProductSet() {
		// The three products should be the "top products" (with zero sale)
		assertEquals(3, companyReader.getCompany().getTopProducts().size());
	}
	
	@Test
	public void readSales() throws IOException {
		String input = "2\n"
				+ "Paris|Bob|Foo|1\n"
				+ "Lyon|Alice|Foo|1\n";
		
		companyReader.readSales(new BufferedReader(new StringReader(input)));
		
		// Both should be top clerk with the same sale amount
		assertEquals(2, companyReader.getCompany().getTopSalesClerks().size());
	}

}
