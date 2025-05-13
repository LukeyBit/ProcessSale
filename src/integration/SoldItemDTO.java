package integration;

import model.Item;

public record SoldItemDTO(Item item, int quantity, float subtotal) {
    /**
     * Constructor for the SoldItemDTO class.
     * Initializes the item, quantity, and calculates the subtotal.
     *
     * @param item     The item being sold.
     * @param quantity The quantity of the item sold.
     * @param subtotal The subtotal for the item sold.
     */
    public SoldItemDTO(Item item, int quantity, float subtotal) {
        this.item = item;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
}
