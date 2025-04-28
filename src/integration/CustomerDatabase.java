package integration;

import model.Customer;

public class CustomerDatabase {
    public Customer fetchCustomer(int customerIdentifier) {
        return new Customer(customerIdentifier);
    }
}
