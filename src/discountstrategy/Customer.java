
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
        if (customerId == null) {
            throw new IllegalArgumentException("CustomerID must not be null!");
        }
        this.customerId = customerId;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        if (firstName.contains("1-9") || firstName.length() == 0 || firstName == null) {
            throw new IllegalArgumentException("Invalid value entered!");
        }
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        if (lastName.contains("1-9") || lastName.length() == 0 || lastName == null) {
            throw new IllegalArgumentException("Invalid value entered!");
        }
        this.lastName = lastName;
    }

    
}
