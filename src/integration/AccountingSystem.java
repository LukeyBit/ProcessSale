package integration;

import model.Sale;

/**
 * A class to handle accounting. This is not a necessity for the current assignment
 * which is why it simply returns a message when called, for unit test purposes
 */
public class AccountingSystem {
    /**
     * Method to report a sale to the accounting system.
     *
     * @param sale The sale to be reported.
     */
    public static void reportSale(Sale sale) {
        System.out.println("Sale reported to accounting system");
    }
}
