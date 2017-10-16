package discountstrategy;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Jenna
 */
public class Receipt {
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
    private LineItem[] lineItems;
    private DatabaseStrategy db;
    private OutputStrategy outputStrategy;

    public Receipt(String customerId, DatabaseStrategy db) {
        setDb(db);
        receiptId++;
        customer = db.findCustomerById(customerId);
        lineItems= new LineItem[0];
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
    
    public final void setOutputStrategy(OutputStrategy outputStrategy) {
        if (outputStrategy == null) {
            throw new IllegalArgumentException("Database must not be null!");
        }
        this.outputStrategy = outputStrategy;
    }

    public final void setDb(DatabaseStrategy db) {
        if (db == null) {
            throw new IllegalArgumentException("Database must not be null!");
        }
        this.db = db;
    }
    
    public void addItemToSale(String productId, int qty) {
       LineItem item = new LineItem(productId, qty, db);
       addToArray(item);
    }
    
    private void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }
    
    public final void formatHeader() {
         System.out.println(RECEIPT_ID + receiptId + NEWLINE + CUSTOMER_ID +
            getCustomer().getCustomerId() + NEWLINE + WELCOME_MESSAGE + NEWLINE);
        System.out.println(PRODUCT_ID + TAB + PRODUCT_NAME + TAB + TAB
            + QTY + TAB + PRICE + TAB + DISCOUNT_AMT + TAB + SUBTOTAL);
        System.out.println("---------------------------------------------------------------------------------");
    }
    
    public final void formatLineItems() {
        for (LineItem li : lineItems) {
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
        System.out.println(TOTAL + TAB + TAB + TAB + TAB + TAB + TAB + DOLLAR_SIGN + subTotal);
        System.out.println(SAVINGS + TAB + TAB + TAB + TAB + TAB + DOLLAR_SIGN + discountTotal);
        System.out.println(NEWLINE);
    }
      
}
