package integration;

/**
 * A class to handle accounting. This is not a necessity for the current assignment
 * which is why it simply returns a message when called, for unit integration.test purposes
 */
public class AccountingSystem {
    /**
     * Method to report a sale to the accounting system.
     *
     * @param sale The sale to be reported.
     */
    public static void reportSale(SaleDTO sale) {
        System.out.println("Sale reported to accounting system");
    }
}
