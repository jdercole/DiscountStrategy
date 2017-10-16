package discountstrategy;

/**
 *
 * @author Jenna
 */
public class StartUp {

    public static void main(String[] args) {
       DatabaseStrategy db = new InMemoryDatabase();
       POSTerminal pos = new POSTerminal(db);
       
       pos.startNewSale("A1");
       pos.addItemToSale("U6781", 2);
       pos.addItemToSale("X0678", 1);
       pos.endSale();
       
       pos.startNewSale("B2");
       pos.addItemToSale("D3110", 2);
       pos.addItemToSale("H4496", 1);
       pos.addItemToSale("U6781", 4);
       pos.endSale();
       
       pos.startNewSale("C4");
       pos.addItemToSale("A1013", 2);
       pos.addItemToSale("D3110", 1);
       pos.endSale();
    }   
}
