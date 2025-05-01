package integration;

import model.Customer;
import model.Discount;
import model.SoldItem;
import java.util.ArrayList;

/**
 * Handles individual discounts for each item in Sale. Takes an Item from Sale, checks
 * if it has any discount, then applies the itemdiscount, as well as the total and customer discount.
 * Lastly, it returns the updated total discount for the receipt
 */
public class DiscountDatabase {
    /**
     * Fetches discounts and applies the discount to a Sale
     * @param items items that are in the current Sale
     * @param totalCost the total cost of the current Sale, which gets adjusted
     * @param customer the ID of the customer is needed to check for any customer discounts
     * @return the total discount that was applied to the current Sale
     */
    public static Discount fetchDiscount(ArrayList<SoldItem> items, float totalCost, Customer customer) {
        // Simulate fetching discount from a database
        float itemsDiscount = 0.0f;
        float totalDiscount = 0.0f;
        float customerDiscount = 0.0f;

        // Example logic to determine discounts
        if (items.size() > 5) {
            itemsDiscount = 10.0f; // Discount for buying more than 5 items
        }
        if (totalCost > 100.0f) {
            totalDiscount = 5.0f; // Discount for total cost over 100
        }
        if (customer != null) {
            customerDiscount = 2.0f; // Additional discount for loyal customers
        }

        return new Discount(itemsDiscount, totalDiscount, customerDiscount);
    }
}
