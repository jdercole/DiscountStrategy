
package discountstrategy;

/**
 *
 * @author Jenna
 */

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;

    public Customer(String customerId, String firstName, String lastName) {
        setCustomerId(customerId);
        setFirstName(firstName);
        setLastName(lastName);
    }
    
    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
}
