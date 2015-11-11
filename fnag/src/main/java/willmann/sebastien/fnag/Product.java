package willmann.sebastien.fnag;

import java.math.BigDecimal;

/**
 * This class represents a product.
 * 
 * Two products are considered equals if they have the same reference.
 * 
 * This class is immutable.
 */
public final class Product {
	
	private final String reference;
	private final BigDecimal price;
	private final String description;

	public Product(String reference, BigDecimal price, String description) {
		this.reference = reference;
		this.price = price;
		this.description = description;
	}

	public String getReference() {
		return reference;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
		Product other = (Product) obj;
		if (reference == null) {
			if (other.reference != null) {
				return false;
			}
		} else if (!reference.equals(other.reference)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Product [reference=" + reference + ", price=" + price + ", description=" + description + "]";
	}

}
