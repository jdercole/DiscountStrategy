
package discountstrategy;

/**
 *
 * @author Jenna
 */
public class QtyDiscount implements DiscountStrategy {
    private double percentOff;
    private double minQty;
    
    public QtyDiscount(double percentOff, double minQty) {
        setPercentOff(percentOff);
        setMinQty(minQty); 
   }

    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) {
        if (percentOff < 0 || percentOff > 1) {
            throw new IllegalArgumentException("Must be a percentage between 0 and 1!");
        } else {
            this.percentOff = percentOff;
        }
    }

    public final double getMinQty() {
        return minQty;
    }

    public final void setMinQty(double minQty) {
        if (minQty < 0) {
            throw new IllegalArgumentException("Minimum quantity must be greater than 0!");
        }
        this.minQty = minQty;
    }
   
    @Override
    public double calculateDiscountedPrice(int qty, double unitCost) {
        double discountAmt = 0;
        
        if (qty < minQty) {
            discountAmt = 0;
        } else {
            discountAmt = qty * unitCost * percentOff;
        }
        return discountAmt;
    }

    @Override
    public double calculateMoneySaved(int qty, double unitCost) {
         double moneySaved = 0;
        
        if (qty < minQty) {
            moneySaved = 0;
        } else {
            moneySaved = (unitCost * qty) - (qty * unitCost * percentOff);
        }
        return moneySaved;
    }
    
}
