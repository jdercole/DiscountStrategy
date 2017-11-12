package discountstrategy;

import edu.wctc.advjava.jrd.datetime.DateUtilities;
import edu.wctc.advjava.jrd.datetime.DateValidator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenna
 */
public class Receipt {
    public final String DATE = "DATE: ";
    public final String RECEIPT_ID = "RECEIPT_ID: ";
    public final String NEWLINE = "\n";
    public final String TAB = "\t";
    public final String CUSTOMER_ID = "CUSTOMER_ID: ";
    public final String PRODUCT_ID = "PRODUCT_ID";
    public final String PRODUCT_NAME = "PRODUCT_NAME";
    public final String QTY = "QTY";
    public final String PRICE = "PRICE";
    public final String WELCOME_MESSAGE = "Welcome to Kohl's Department Store!";
    public final String DISCOUNT_AMT = "DISCOUNT";
    public final String SUBTOTAL = "SUBTOTAL";
    public final String TOTAL = "TOTAL: ";
    public final String SAVINGS = "YOU SAVED: ";
    public final String DOLLAR_SIGN = "$ ";
    public final String OPEN_PAREN = "(";
    public final String CLOSED_PAREN = ")";
    public static int receiptId;
    private Customer customer;
    //private LineItem[] lineItems;
    private List<LineItem> lineItems;
    private DatabaseStrategy db;
    private OutputStrategy outputStrategy;
    private DateUtilities dateUtility;

    public Receipt(String customerId, DatabaseStrategy db) {
        setDateUtility(new DateUtilities(new DateValidator()));
        setDb(db);
        receiptId++;
        customer = db.findCustomerById(customerId);
        lineItems= new ArrayList<>();
        NumberFormat df = new DecimalFormat("#.00"); 
    }
    
    public final DatabaseStrategy getDb() {
        return db;
    }
    
    public final Customer getCustomer() {
        return customer;
    }
    
    public final OutputStrategy getOutputStrategy() {
        return outputStrategy;
    }

    public final DateUtilities getDateUtility() {
        return dateUtility;
    }

    public final void setDateUtility(DateUtilities dateUtility) {
        if (dateUtility == null) {
            throw new IllegalArgumentException("Date utility class cannot be null!");
        }
        this.dateUtility = dateUtility;
    }
    
    public final void setOutputStrategy(OutputStrategy outputStrategy) throws IllegalArgumentException  {
        if (outputStrategy == null) {
            throw new IllegalArgumentException("Database must not be null!");
        }
        this.outputStrategy = outputStrategy;
    }

    public final void setDb(DatabaseStrategy db) throws IllegalArgumentException {
        if (db == null) {
            throw new IllegalArgumentException("Database must not be null!");
        }
        this.db = db;
    }
    
    public final void addItemToSale(String productId, int qty) {
       LineItem item = new LineItem(productId, qty, db);
       //addToArray(item);
       addToList(item);
    }
    
    private void addToList(LineItem lineItem) {
        lineItems.add(lineItem);
    }
    
//    private final void addToArray(LineItem item) {
//        LineItem[] tempItems = new LineItem[lineItems.length + 1];
//        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
//        tempItems[lineItems.length] = item;
//        lineItems = tempItems;
//    }
    
    public final void formatHeader() {
        JOptionPane.showMessageDialog(null, DATE + this.getDateUtility().getCurrentDateTime() + NEWLINE + RECEIPT_ID + receiptId + NEWLINE + CUSTOMER_ID +
            getCustomer().getCustomerId() + NEWLINE + WELCOME_MESSAGE + NEWLINE + 
                PRODUCT_ID + TAB + PRODUCT_NAME + TAB + TAB
            + QTY + TAB + PRICE + TAB + DISCOUNT_AMT + TAB + SUBTOTAL);
         System.out.println(DATE + this.getDateUtility().getCurrentDateTime() + 
            NEWLINE + RECEIPT_ID + receiptId + NEWLINE + CUSTOMER_ID +
            getCustomer().getCustomerId() + NEWLINE + WELCOME_MESSAGE + NEWLINE);
        System.out.println(PRODUCT_ID + TAB + PRODUCT_NAME + TAB + TAB
            + QTY + TAB + PRICE + TAB + DISCOUNT_AMT + TAB + SUBTOTAL);
        System.out.println("---------------------------------------------------------------------------------");
    }
    
    public final void formatLineItems() {
        for (LineItem li : lineItems) {
            JOptionPane.showMessageDialog(null, li.getProduct().getProductId() + TAB 
                    + li.getProduct().getName() + TAB + li.getQuantity() + TAB
                    + li.getProduct().getUnitCost() + TAB + OPEN_PAREN + li.getSavings() + CLOSED_PAREN
                    + TAB + TAB + li.getDiscountAmt());
            System.out.println(li.getProduct().getProductId() + TAB 
                    + li.getProduct().getName() + TAB + li.getQuantity() + TAB
                    + li.getProduct().getUnitCost() + TAB + OPEN_PAREN + li.getSavings() + CLOSED_PAREN
                    + TAB + TAB + li.getDiscountAmt());
        }
        System.out.println(NEWLINE);
    }
    
    public final void formatTotals() {
        double subTotal = 0;
        double discountTotal = 0;
        for (LineItem li : lineItems) {
            subTotal += li.getDiscountAmt();
            discountTotal += li.getSavings();
        }
        JOptionPane.showMessageDialog(null, TOTAL + " " + DOLLAR_SIGN + subTotal 
                + NEWLINE + SAVINGS + " " + DOLLAR_SIGN + discountTotal);
        System.out.println(TOTAL + TAB + TAB + TAB + TAB + TAB + TAB + DOLLAR_SIGN + subTotal);
        System.out.println(SAVINGS + TAB + TAB + TAB + TAB + TAB + DOLLAR_SIGN + discountTotal);
        System.out.println(NEWLINE);
    }

 
    
    
      
}
