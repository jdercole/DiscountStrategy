
package discountstrategy;

import java.util.Objects;

/**
 *
 * @author Jenna
 */
public class Product {
    private String productId;
    private String name;
    private double unitCost;
    private DiscountStrategy discountStrategy;
    
    public Product(String productId, String name, double unitCost, DiscountStrategy discountStrategy) {
        setProductId(productId);
        setName(name);
        setUnitCost(unitCost);
        setDiscountStrategy(discountStrategy);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.productId);
        return hash;
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.productId, other.productId)) {
            return false;
        }
        return true;
    }
    
    public final double getDiscountAmt(int qty) {
        return discountStrategy.calculateDiscountedPrice(qty, unitCost);
    }

    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) throws IllegalArgumentException  {
        if (productId == null || productId.length() == 0) {
            throw new IllegalArgumentException("Product ID must be set!");
        }
        this.productId = productId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) throws IllegalArgumentException  {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        }
        this.name = name;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) throws IllegalArgumentException  {
        if (unitCost < 0) {
            throw new IllegalArgumentException("Unit cost cannot be less than zero!");
        }
        this.unitCost = unitCost;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(DiscountStrategy discountStrategy) throws IllegalArgumentException  {
        if (discountStrategy == null) {
            throw new IllegalArgumentException("Discount strategy cannot be null!");
        }
        this.discountStrategy = discountStrategy;
    }
    

}
