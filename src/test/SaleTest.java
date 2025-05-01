package test;

import integration.InventorySystem;
import model.Discount;
import model.Item;
import model.Sale;
import model.VatRate;
import org.junit.jupiter.api.Test;

public class SaleTest {

    /**
     * This test case verifies the functionality of the Sale class.
     * It creates a Sale object, adds items to it, applies a discount,
     * and checks if the total price is calculated correctly.
     */
    @Test
    void testSale() {
        // Create a Sale object
        Sale sale = new Sale();

        // Add items to the sale
        sale.addItem(new Item(1, "Test1", "Testing item 1", 100f, VatRate.VAT_RATE1), 2);
        sale.addItem(new Item(2, "Test2", "Testing item 2", 200f, VatRate.VAT_RATE1), 1);

        // Calculate total price
        float totalPrice = sale.getTotal();
        System.out.println("Total Price: " + totalPrice);

        // Apply discount
        Discount discount = new Discount(10.0f, 5.0f, 2.0f);
        sale.setDiscount(discount);

        // Calculate total price after discount
        float totalPriceAfterDiscount = sale.getTotal();
        System.out.println("Total Price After Discount: " + totalPriceAfterDiscount);

        // Pay for the sale
        sale.pay(totalPriceAfterDiscount);
        System.out.println("Amount Paid: " + sale.getAmountPaid());
        System.out.println("Change: " + sale.getChange());
        // Print receipt
        sale.createReceipt();
        System.out.println("Receipt created.");
        // Check if the sale is completed
        assert sale.isCompleted() : "Sale should be completed after payment";
        // Check if the inventory is updated
        InventorySystem.updateInventory(sale.getItems());
        System.out.println("Inventory updated.");
        // Check if the sale date and time are set
        assert sale.getSaleDateTime() != null : "Sale date and time should be set";
        // Check if the total price is correct
        float expectedTotalPrice = ((100f * 2 + 200f) * 1.25f - 10.0f) * 0.95f * 0.98f;

        assert Math.abs(totalPriceAfterDiscount - expectedTotalPrice) < 0.01 : "Total price after discount should be " + expectedTotalPrice;
        // Check if the change is correct
        float expectedChange = totalPriceAfterDiscount - sale.getAmountPaid();
        assert Math.abs(expectedChange - sale.getChange()) < 0.01 : "Change should be " + expectedChange;
        // Check if the items are sold
        assert sale.getItems().size() == 2 : "There should be 2 items sold";

        // Check if the items are sold correctly
        assert sale.getItems().get(0).getItem().getName().equals("Test1") : "First item should be Test1";
        assert sale.getItems().get(1).getItem().getName().equals("Test2") : "Second item should be Test2";
    }
}
