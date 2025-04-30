package integration;

import model.Item;
import model.SoldItem;
import model.VatRate;

import java.util.ArrayList;

public class InventorySystem {
    public Item getItem(int itemIdentifier) {
        return switch (itemIdentifier) {
            case 1 -> new Item(1, "Milk 1L", "Description 1", 100.0f, VatRate.VAT_RATE1);
            case 2 -> new Item(2, "Apple", "Description 2", 200.0f, VatRate.VAT_RATE2);
            case 3 -> new Item(3, "Pear", "Description 3", 300.0f, VatRate.VAT_RATE3);
            default -> new Item(4, "Snickers", "Description 4", 10.0f, VatRate.VAT_RATE1);
        };
    }

    public void updateInventory(ArrayList<SoldItem> soldItems) {
        // Logic to update inventory based on sold items
        System.out.println("Inventory updated with sold items");
    }
}
