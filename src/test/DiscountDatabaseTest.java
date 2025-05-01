package test;

import integration.DiscountDatabase;
import model.*;
import org.junit.jupiter.api.Test;

public class DiscountDatabaseTest {
    @Test
    void testFetchDiscount() {
        // Create a Sale object
        Sale sale = new Sale();

        // Add items to the sale
        sale.addItem(new Item(1, "Test1", "Testing item 1", 10f, VatRate.VAT_RATE1), 2);
        sale.addItem(new Item(2, "Test2", "Testing item 2", 20f, VatRate.VAT_RATE1), 1);

        // Set customer to null for testing
        sale.setCustomer(null);

        System.out.println("Total Price: " + sale.getTotal());

        // Apply discount
        Discount discount = DiscountDatabase.fetchDiscount(sale.getItems(), sale.getTotal(), sale.getCustomer());

        assert discount.getItemsDiscount() == 0.0f &&
               discount.getTotalDiscount() == 0.0f &&
               discount.getCustomerDiscount() == 0.0f : "Discount should be 0.0f for no items and no customer";

        for (int i = 3; i <= 6; i++) {
            sale.addItem(new Item(i, "Test" + i, "Testing item " + i, 100f * i, VatRate.VAT_RATE1), 1);
        }

        sale.setCustomer(new Customer(1));

        discount = DiscountDatabase.fetchDiscount(sale.getItems(), sale.getTotal(), sale.getCustomer());

        assert discount.getItemsDiscount() == 10.0f &&
               discount.getTotalDiscount() == 5.0f &&
               discount.getCustomerDiscount() == 2.0f : "Discount should be 10.0f for items, 5.0f for total and 2.0f for customer";
    }
}
