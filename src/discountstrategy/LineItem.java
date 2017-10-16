
package discountstrategy;

/**
 *
 * @author Jenna
 */
public class LineItem {
    private Product product;
    private int quantity;
    
    public LineItem(String prodId, int quantity, DatabaseStrategy db) {
        setProduct(db.findProductById(prodId));
        setQuantity(quantity);
    }
    
    public double getSubTotal() {
        return product.getUnitCost() * quantity;
    }
    
    public double getDiscountAmt() {
        return product.getDiscountAmt(quantity);
    }
    
    public double getSavings() {
        return product.getDiscountStrategy().calculateMoneySaved(quantity, product.getUnitCost());
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product must be provided!");
        }
        this.product = product;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than 0!");
        }
        this.quantity = quantity;
    }
    
    
}
