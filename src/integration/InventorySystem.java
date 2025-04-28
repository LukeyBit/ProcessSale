package integration;

import model.Item;
import model.SoldItem;
import model.VatRate;

import java.util.ArrayList;

public class InventorySystem {
    public Item getItem(int itemIdentifier) {
        return switch (itemIdentifier) {
            case 1 -> new Item(1, "Item 1", "Description 1", 100.0f, VatRate.VAT_RATE1);
            case 2 -> new Item(2, "Item 2", "Description 2", 200.0f, VatRate.VAT_RATE2);
            case 3 -> new Item(3, "Item 3", "Description 3", 300.0f, VatRate.VAT_RATE3);
            default -> new Item(4, "Item 4", "Description 4", 10.0f, VatRate.VAT_RATE1);
        };
    }

    public void updateInventory(ArrayList<SoldItem> soldItems) {
        // Logic to update inventory based on sold items
        System.out.println("Inventory updated with sold items");
    }
}
