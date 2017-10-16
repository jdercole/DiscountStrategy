
package discountstrategy;

/**
 *
 * @author Jenna
 */
public class FlatAmountDiscount implements DiscountStrategy {
    private double discountAmount;
    
    public FlatAmountDiscount(double discountAmount) {
        setDiscountAmount(discountAmount);
    }

    public final double getDiscountAmount() {
        return discountAmount;
    }

    public final void setDiscountAmount(double discountAmount) {
        if (discountAmount < 0) {
            throw new IllegalArgumentException("Discount amount must be equal to or greater than 0!");
        } else {
            this.discountAmount = discountAmount;
        }
    }

    @Override
    public double calculateDiscountedPrice(int qty, double unitCost) {
        return (unitCost * qty) - discountAmount;
    }

    @Override
    public double calculateMoneySaved(int qty, double unitCost) {
        return (unitCost * qty) - ((unitCost * qty) - discountAmount);
    }
    
}
