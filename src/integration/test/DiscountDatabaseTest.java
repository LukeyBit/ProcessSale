package integration.test;

import integration.DiscountDatabase;
import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        // Apply discount
        final Discount discount1 = DiscountDatabase.fetchDiscount(sale.getItems(), sale.getTotal(), sale.getCustomer());

        assertAll("Discount 1 Assertions",
            () -> assertEquals(0.0f, discount1.getItemsDiscount(), "Items discount should be 0.0f"),
            () -> assertEquals(0.0f, discount1.getTotalDiscount(), "Total discount should be 0.0f"),
            () -> assertEquals(0.0f, discount1.getCustomerDiscount(), "Customer discount should be 0.0f")
        );

        for (int i = 3; i <= 6; i++) {
            sale.addItem(new Item(i, "Test" + i, "Testing item " + i, 100f * i, VatRate.VAT_RATE1), 1);
        }

        sale.setCustomer(new Customer(1));

        final Discount discount2 = DiscountDatabase.fetchDiscount(sale.getItems(), sale.getTotal(), sale.getCustomer());

        assertAll("Discount 2 Assertions",
            () -> assertEquals(10.0f, discount2.getItemsDiscount(), "Items discount should be 10.0f"),
            () -> assertEquals(5.0f, discount2.getTotalDiscount(), "Total discount should be 5.0f"),
            () -> assertEquals(2.0f, discount2.getCustomerDiscount(), "Customer discount should be 2.0f")
        );
    }
}
