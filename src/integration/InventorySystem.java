package integration;

import model.Item;
import model.SoldItem;
import model.VatRate;

import java.util.ArrayList;

/**
 * Handles each product the store has in stock, with an integer as identifier as well
 * as name, price and vatRate for the given product
 */
public class InventorySystem {
    /**
     * Function used to get an item from the InventorySystem while "scanning" a product at the POS
     * @param itemIdentifier an integer value used to find an item in the inventorySystem
     * @return an object Item, which holds its name, a description of the product, a price and its vatRate
     */
    public static Item getItem(int itemIdentifier) {
        return switch (itemIdentifier) {
            case 1 -> new Item(1, "Milk 1L", "Description 1", 100.0f, VatRate.VAT_RATE1);
            case 2 -> new Item(2, "Apple", "Description 2", 200.0f, VatRate.VAT_RATE2);
            case 3 -> new Item(3, "Pear", "Description 3", 300.0f, VatRate.VAT_RATE3);
            default -> new Item(4, "Snickers", "Description 4", 10.0f, VatRate.VAT_RATE1);
        };
    }

    /**
     * Updates the inventory after each Sale, to subtract the sold items from the database
     * @param soldItems an ArrayList of items that were sold in the Sale
     */
    public static void updateInventory(ArrayList<SoldItem> soldItems) {
        // Logic to update inventory based on sold items
        System.out.println("Inventory updated with sold items");
    }
}
