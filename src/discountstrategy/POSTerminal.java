package discountstrategy;

/**
 *
 * @author Jenna
 */
public class POSTerminal {
    private Receipt receipt;
    private DatabaseStrategy db;
    
    public POSTerminal(DatabaseStrategy db) {
        setDb(db);
    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setDb(DatabaseStrategy db) throws IllegalArgumentException {
        if (db == null) {
            throw new IllegalArgumentException("Database must be provided!");
        }
        this.db = db;
    }

    public final DatabaseStrategy getDb() {
        return db;
    }
          
    public final void startNewSale(String customerId) {
        receipt = new Receipt(customerId, db);
    }

    public final void addItemToSale(String productId, int qty) {
       receipt.addItemToSale(productId, qty);
    }

    private final void generateReceipt() {
       receipt.formatHeader();
       receipt.formatLineItems();
       receipt.formatTotals();
    }
    
    public final void endSale() {
        generateReceipt();
    }
}


