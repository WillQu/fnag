package willmann.sebastien.fnag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class represents a store
 */
public final class Store {
	
	private final String name;
	
	private final Map<String, SalesClerk> salesClerks = new HashMap<>();

	public Store(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Set<SalesClerk> getSalesClerk() {
		return new HashSet<>(this.salesClerks.values());
	}
	
	/**
	 * Add a new sales record for this store
	 * @param clerkName the sales clerk name
	 * @param product the product
	 * @param number the number of sales
	 */
	public void addRecord(String clerkName, Product product, int number) {
		if(!this.salesClerks.containsKey(clerkName)) {
			this.salesClerks.put(clerkName, new SalesClerk(clerkName, this));
		}
		
		SalesClerk clerk = this.salesClerks.get(clerkName);
		clerk.addSale(product, number);
	}
	
	/**
	 * 
	 * @return the sales results for this store
	 */
	public Map<Product, Integer> getSalesResults() {
		Map<Product, Integer> result = new HashMap<>();
		for(SalesClerk clerk : this.salesClerks.values()) {
			for(Entry<Product, Integer> entry : clerk.getSales().entrySet()) {
				Product key = entry.getKey();
				int currentValue = result.containsKey(key) ? result.get(key) : 0;
				result.put(key, currentValue + entry.getValue());
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Store [name=" + name + ", salesClerks=" + salesClerks + "]";
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
		Store other = (Store) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
}
