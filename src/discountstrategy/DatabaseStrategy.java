
package discountstrategy;

/**
 *
 * @author Jenna
 */
public interface DatabaseStrategy {
    public abstract Customer findCustomerById(String customerId);
    
    public abstract Product findProductById(String productId);
}
