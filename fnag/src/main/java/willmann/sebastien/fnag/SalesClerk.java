package willmann.sebastien.fnag;

import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a sales clerk.
 * 
 * Two clerks are considered equals if they have the same name.
 */
public final class SalesClerk {
	
	private final String name;
	private final Map<Product, Integer> sales = new HashMap<>();

	public SalesClerk(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Add a new sales record for the specified product.
	 * @param product the product to add. Overwrites any record for the same product.
	 * @param number the number of sales for the specified product.
	 */
	public void addSale(Product product, int number) {
		sales.put(product, number);
	}
	
	/**
	 * 
	 * @return the total number of sales for this sales clerk
	 */
	public int computeTotalSales() {
		return this.sales.values().stream().mapToInt(Integer::intValue).sum();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SalesClerk other = (SalesClerk) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SalesClerk [name=" + name + ", sales=" + sales + "]";
	}

}
