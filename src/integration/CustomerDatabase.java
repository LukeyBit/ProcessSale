package integration;

import model.Customer;

/**
 * Handles Customers that shop at the store, to give appropriate discounts.
 * Not fully implemented since it is not a necessity for the current assignment
 */
public class CustomerDatabase {
    /**
     * Used to find a customer in the customerDatabase
     * @param customerIdentifier used to identify a customer given an integer
     * @return a customer
     */
    public static Customer fetchCustomer(int customerIdentifier) {
        return new Customer(customerIdentifier);
    }
}
