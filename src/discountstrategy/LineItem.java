
package discountstrategy;

import java.util.Objects;

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
    
    public final double getSubTotal() {
        return product.getUnitCost() * quantity;
    }
    
    public final double getDiscountAmt() {
        return product.getDiscountAmt(quantity);
    }
    
    public final double getSavings() {
        return product.getDiscountStrategy().calculateMoneySaved(quantity, product.getUnitCost());
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) throws IllegalArgumentException  {
        if (product == null) {
            throw new IllegalArgumentException("Product must be provided!");
        }
        this.product = product;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) throws IllegalArgumentException  {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than 0!");
        }
        this.quantity = quantity;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LineItem other = (LineItem) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
