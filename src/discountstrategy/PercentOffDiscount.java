
package discountstrategy;

/**
 *
 * @author Jenna
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double percentOff;
    
    public PercentOffDiscount(double percentOff) {
        setPercentOff(percentOff);
    }

    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) {
        this.percentOff = percentOff;
    }
    
    @Override
    public double calculateDiscountedPrice(int qty, double unitCost) {
        return (unitCost * qty) - (unitCost * qty * percentOff);
    }

    @Override
    public double calculateMoneySaved(int qty, double unitCost) {
        return (unitCost * qty) * percentOff;
    }
    
}
