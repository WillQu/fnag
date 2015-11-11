package willmann.sebastien.fnag;

import java.math.BigDecimal;

public final class ProductReader {
	
	private final static String SEPARATOR = "\\|";
	
	public static Product readProduct(String line) {
		String splitLine[] = line.split(SEPARATOR);
		return new Product(splitLine[0], new BigDecimal(splitLine[1]), splitLine[2]);
	}

}
