package model.test;

import model.Discount;
import model.Item;
import model.Sale;
import model.VatRate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {

    /**
     * This test case verifies the functionality of the Sale class.
     * It creates a Sale object, adds items to it, applies a discount,
     * and checks if the total price is calculated correctly.
     */
    @Test
    void testSale() {
        Sale sale = new Sale();

        sale.addItem(new Item(1, "Test1", "Testing item 1", 100f, VatRate.VAT_RATE1), 2);
        sale.addItem(new Item(2, "Test2", "Testing item 2", 200f, VatRate.VAT_RATE1), 1);
        sale.addItem(new Item(1, "Test1", "Testing item 1", 100f, VatRate.VAT_RATE1), 1);

        float totalPrice = sale.getTotal();

        Discount discount = new Discount(10.0f, 5.0f, 2.0f);
        sale.setDiscount(discount);

        float totalPriceAfterDiscount = sale.getTotal();

        sale.pay(totalPriceAfterDiscount);

        float expectedTotalPrice = ((100f * 3 + 200f) * 1.25f - 10.0f) * 0.95f * 0.98f;

        float expectedChange = totalPriceAfterDiscount - sale.getAmountPaid();


        assertAll("Sale Assertions",
                () -> assertNotEquals(null, sale.getSaleDateTime(), "Sale date and time should be set"),
                () -> assertEquals(expectedTotalPrice, totalPriceAfterDiscount, "Total price after discount should be " + expectedTotalPrice),
                () -> assertEquals(expectedChange, sale.getChange(), "Change should be " + expectedChange),
                () -> assertEquals(2, sale.getItems().size(), "There should be 2 items sold"),
                () -> assertEquals("Test1", sale.getItems().get(0).getItem().getName(), "First item should be Test1"),
                () -> assertEquals("Test2", sale.getItems().get(1).getItem().getName(), "Second item should be Test2")
        );
    }
}
