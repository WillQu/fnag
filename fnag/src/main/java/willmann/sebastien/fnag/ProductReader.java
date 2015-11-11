package willmann.sebastien.fnag;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * This class contains static methods to read {@link Product} objects from input
 *
 */
public final class ProductReader {
	
	private final static String SEPARATOR = "\\|";
	
	/**
	 * Reads products from the specified {@link BufferedReader}.
	 * The first line must contain the number of products to read.
	 * 
	 * @param reader A buffered reader to read from
	 * @return a set containing the products
	 * @throws IOException
	 */
	public static Set<Product> readProductSet(BufferedReader reader) throws IOException {
		int linesNumber = Integer.parseInt(reader.readLine());
		Set<Product> result = new HashSet<>();
		for(int i = 0; i < linesNumber; i++) {
			result.add(readProduct(reader.readLine()));
		}
		return result;
	}
	
	/**
	 * Reads a single line
	 * @param line
	 * @return the product
	 */
	public static Product readProduct(String line) {
		String splitLine[] = line.split(SEPARATOR);
		return new Product(splitLine[0], new BigDecimal(splitLine[1]), splitLine[2]);
	}

}
