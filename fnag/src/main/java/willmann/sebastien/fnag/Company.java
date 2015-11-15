package willmann.sebastien.fnag;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Class for the whole company. This class contains all the products and stores.
 */
public final class Company {
	
	private Map<String, Product> products = new HashMap<>();
	
	private Map<String, Store> stores = new HashMap<>();
	
	/**
	 * Add a product to the inventory
	 * @param reference the product reference
	 * @param price the product price
	 * @param description description of the product
	 */
	public void addProduct(String reference, BigDecimal price, String description) {
		this.products.put(reference, new Product(reference, price, description));
	}
	
	/**
	 * Add a new sale record
	 * @param storeName the name of the store where the sale took place
	 * @param salesClerkName the name of the sales clerk
	 * @param productRef the reference of the sold product
	 * @param number the number of sales
	 */
	public void addSale(String storeName, String salesClerkName, String productRef, int number) {
		if(!this.stores.containsKey(storeName)) {
			this.stores.put(storeName, new Store(storeName));
		}
		
		this.stores.get(storeName).addRecord(salesClerkName, this.products.get(productRef), number);
	}
	
	/**
	 * 
	 * @return a map containing the most sold products, and the quantities.
	 * The map contains only one product unless there is more than one top product with the same quantity.
	 */
	public Map<Product, Integer> getTopProducts() {
		Map<Product, Integer> result = new HashMap<>();
		int bestNumber = 0;
		
		for(Product product : this.products.values()) {
			int count = 0;
			for(Store store : this.stores.values()) {
				Integer storeCount = store.getSalesResults().get(product);
				count += storeCount != null ? storeCount : 0;
			}
			if(count > bestNumber) {
				result.clear();
				bestNumber = count;
			}
			if(count == bestNumber) {
				result.put(product, bestNumber);
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return a map containing the top sales clerks, and the total amount.
	 * The map contains only one element, unless there is more than one top clerk with the same amount.
	 */
	public Map<SalesClerk, BigDecimal> getTopSalesClerks() {
		Map<SalesClerk, BigDecimal> result = new HashMap<>();
		BigDecimal bestAmount = BigDecimal.ZERO;
		
		for(Store store : this.stores.values()) {
			for(SalesClerk clerk : store.getSalesClerk()) {
				BigDecimal clerkResult = BigDecimal.ZERO;
				for(Entry<Product, Integer> entry : clerk.getSales().entrySet()) {
					clerkResult = entry.getKey().getPrice()
							.multiply(new BigDecimal(entry.getValue()))
							.add(clerkResult);
				}
				if(clerkResult.compareTo(bestAmount) > 0) {
					result.clear();
					bestAmount = clerkResult;
				}
				if(clerkResult.compareTo(bestAmount) == 0) {
					result.put(clerk, bestAmount);
				}
			}
		}
		
		return result;
	}

}
