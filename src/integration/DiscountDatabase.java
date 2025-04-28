package integration;

import model.Customer;
import model.Discount;
import model.SoldItem;
import java.util.ArrayList;

public class DiscountDatabase {
    public Discount fetchDiscount(ArrayList<SoldItem> items, float totalCost, Customer customer) {
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
