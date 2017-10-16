
package discountstrategy;

/**
 *
 * @author Jenna
 */
public class InMemoryDatabase implements DatabaseStrategy {
    private Customer[] customers = {
      new Customer("A1", "Joe", "Johansen"),
      new Customer("B2", "Jen", "Smith"),
      new Customer("C4", "Adam", "Tyson")
    };

    private Product[] products = {
        new Product("A1013", "Glitter Gel Pen           ", 3.99, new NoDiscount()),
        new Product("U6781", "Fanta Soda - Grape        ", 1.99, new QtyDiscount(0.50, 2)),
        new Product("X0678", "Cuisinart Food Dehydrator", 89.99, new FlatAmountDiscount(10.00)),
        new Product("D3110", "Men's Cabled Sweater      ", 59.99, new PercentOffDiscount(0.15)),
        new Product("H4496", "Lawn Fertilizer - 50 lbs  ", 16.99, new NoDiscount())
    };

    @Override
    public Customer findCustomerById(String customerId) {
       if(customerId == null || customerId.length() == 0) {
           throw new IllegalArgumentException("CustomerID must be provided!");
       } 
       
       Customer customer = null;
       for(Customer c : customers) {
           if(customerId.equals(c.getCustomerId())) {
                customer = c;
                break;
           }
       }
       return customer;
    }

    @Override
    public Product findProductById(String productId) {
        if(productId == null || productId.length() == 0) {
            throw new IllegalArgumentException("Product ID must be provided!");
        }
        
        Product product = null;
        for (Product p : products) {
            if (productId.equals(p.getProductId())) {
                product = p;
                break;
            }
        }
        return product;
    }
    
}
