
package discountstrategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jenna
 */
public class PercentOffDiscountTest {
    private PercentOffDiscount pod;
    
    public PercentOffDiscountTest() {
        pod = new PercentOffDiscount(.56);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPercentOff method, of class PercentOffDiscount.
     */
//    @Test 
//    public void percentOffShouldBeBetweenZeroAndOne() {
//        pod.setPercentOff(.24);
//        assertTrue();
//    }
    /**
     * Test below should throw an exception if an unacceptable value is set.
     * */
    @Test(expected = IllegalArgumentException.class)
    public void percentageOutOfAcceptableRangeShouldThrowException() {
        pod.setPercentOff(45.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void percentageShouldNotBeNegative() {
        pod.setPercentOff(-56);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void savingsCalculatedShouldNotReturnNegativeValues() {
        pod.calculateMoneySaved(2, -45.67);
    }
    
    @Test
    public void calculateDiscountedPriceShouldReturnPositiveNumber() {
        double price = pod.calculateDiscountedPrice(5, 3.99);
        assertTrue(price > 0);
    }
    
}
