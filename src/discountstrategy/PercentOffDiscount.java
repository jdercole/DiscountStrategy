
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

    public final void setPercentOff(double percentOff) throws IllegalArgumentException {
        if (percentOff > 0.99 || percentOff < 0) {
            throw new IllegalArgumentException("Percentage must be greater than 0 and less than 1!");
        }
        this.percentOff = percentOff;
    }
    
    @Override
    public double calculateDiscountedPrice(int qty, double unitCost) {
        if (qty < 0 || unitCost < 0) {
            throw new IllegalArgumentException("Unit cost and quantity both should be positive!");
        }
        return (unitCost * qty) - (unitCost * qty * percentOff);
    }

    @Override
    public double calculateMoneySaved(int qty, double unitCost) {
        if (unitCost < 0 || qty < 0) {
            throw new IllegalArgumentException("Unit cost and quantity both should be positive values!");
        }
        return (unitCost * qty) * percentOff;
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
        final PercentOffDiscount other = (PercentOffDiscount) obj;
        if (Double.doubleToLongBits(this.percentOff) != Double.doubleToLongBits(other.percentOff)) {
            return false;
        }
        return true;
    }
    
    
    
}
