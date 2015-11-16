package willmann.sebastien.fnag;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Map.Entry;

/**
 * Main program
 */
public final class FnagMain {

	public static void main(String[] args) throws IOException {
		InputStream in;
		if(args.length == 0) {
			in = System.in;
		} else {
			in = new FileInputStream(args[0]);
		}
		
		CompanyReader companyReader = new CompanyReader();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			companyReader.readProductSet(reader);
			companyReader.readSales(reader);
		}
		Company company = companyReader.getCompany();
		
		for(Entry<Product, Integer> sale : company.getTopProducts().entrySet()) {
			Product product = sale.getKey();
			System.out.println(String.format("TOPSALE|%s|%s|%s", product.getReference(), product.getDescription(), sale.getValue()));
		}
		
		for(Entry<SalesClerk, BigDecimal> clerkRecord : company.getTopSalesClerks().entrySet()) {
			SalesClerk clerk = clerkRecord.getKey();
			System.out.println(String.format("TOPSELLER|%s|%s|%s", clerk.getStore().getName(), clerk.getName(), clerkRecord.getValue()));
		}
	}

}
