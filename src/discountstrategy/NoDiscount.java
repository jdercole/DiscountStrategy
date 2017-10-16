
package discountstrategy;

/**
 *
 * @author Jenna
 */
public class NoDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscountedPrice(int qty, double unitCost) {
        return qty * unitCost;
    }

    @Override
    public double calculateMoneySaved(int qty, double unitCost) {
       return 0.00;
    }
    
}
