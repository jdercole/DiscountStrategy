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

    public final void setDb(DatabaseStrategy db) {
        if (db == null) {
            throw new IllegalArgumentException("Database must be provided!");
        }
        this.db = db;
    }

    public final DatabaseStrategy getDb() {
        return db;
    }
          
    public void startNewSale(String customerId) {
        receipt = new Receipt(customerId, db);
    }

    public void addItemToSale(String productId, int qty) {
       receipt.addItemToSale(productId, qty);
    }

    private void generateReceipt() {
       receipt.formatHeader();
       receipt.formatLineItems();
       receipt.formatTotals();
    }
    
    public void endSale() {
        generateReceipt();
    }
}


