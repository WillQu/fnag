package willmann.sebastien.fnag;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * This class contains static methods to read {@link Product} objects from input
 *
 */
public final class CompanyReader {
	
	private final static String SEPARATOR = "\\|";
	
	private final Company company = new Company();
	
	/**
	 * 
	 * @return the company
	 */
	public Company getCompany() {
		return this.company;
	}

	/**
	 * Reads products from the specified {@link BufferedReader}.
	 * The first line must contain the number of products to read.
	 * 
	 * @param reader A buffered reader to read from
	 * @throws IOException
	 */
	public void readProductSet(BufferedReader reader) throws IOException {
		int linesNumber = Integer.parseInt(reader.readLine());
		for(int i = 0; i < linesNumber; i++) {
			readProduct(reader.readLine());
		}
	}
	
	/**
	 * Reads sales from the specified {@link BufferedReader}
	 * The first line must contain the number of sales to read.
	 * 
	 * @param reader A buffered reader to read from.
	 * @throws IOException
	 */
	public void readSales(BufferedReader reader) throws IOException {
		int linesNumber = Integer.parseInt(reader.readLine());
		for(int i = 0; i < linesNumber; i++) {
			readSale(reader.readLine());
		}
	}
	
	private void readSale(String line) {
		String splitLine[] = line.split(SEPARATOR);
		this.company.addSale(splitLine[0], splitLine[1], splitLine[2], Integer.valueOf(splitLine[3]));
		
	}

	/**
	 * Reads a single line
	 * @param line
	 * @return the product
	 */
	private void readProduct(String line) {
		String splitLine[] = line.split(SEPARATOR);
		this.company.addProduct(splitLine[0], new BigDecimal(splitLine[1]), splitLine[2]);
	}

}
