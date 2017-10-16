
package discountstrategy;

/**
 *
 * @author Jenna
 */
public interface DiscountStrategy {
    public abstract double calculateDiscountedPrice(int qty, double unitCost);
    public abstract double calculateMoneySaved(int qty, double unitCost);
}
