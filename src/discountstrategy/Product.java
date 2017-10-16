
package discountstrategy;

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
    
    public final double getDiscountAmt(int qty) {
        return discountStrategy.calculateDiscountedPrice(qty, unitCost);
    }

    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) {
        this.productId = productId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    

}
