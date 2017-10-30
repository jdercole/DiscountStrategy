
package discountstrategy;

/**
 *
 * @author Jenna
 */
public class ConsoleOutputStrategy implements OutputStrategy {
    private Receipt receipt;
    
    @Override
    public final void format() {
       
        
    }

    private void setReceipt(Receipt receipt) throws IllegalArgumentException  {
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt must be set!"); 
        }
        this.receipt = receipt;
    }
    
}
