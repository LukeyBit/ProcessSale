package model;


/**
 * The SoldItem class represents an item sold in the Point of Sale (POS) system.
 * It contains information about the item, its quantity, and the subtotal for that item.
 */
public class SoldItem {
    private Item item;
    private int quantity;
    private float subtotal;

    /**
     * Constructor for the SoldItem class.
     * Initializes the item, quantity, and calculates the subtotal.
     *
     * @param item     The item being sold.
     * @param quantity The quantity of the item sold.
     */
    public SoldItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        setSubtotal();
    }

    /**
     * Constructor for the SoldItem class.
     * Initializes the item and sets the quantity to 1.
     *
     * @return The item being sold.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Gets the quantity of the item sold.
     *
     * @return The quantity of the item sold.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Adds a specified quantity to the current quantity of the item sold.
     *
     * @param quantity The quantity to add.
     */
    public void addQuantity(int quantity) {
        this.quantity += quantity;
        setSubtotal();
    }

    /**
     * Gets the subtotal for the item sold.
     *
     * @return The subtotal for the item sold.
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * Sets the subtotal for the item sold based on its base price, quantity, and VAT rate.
     */
    private void setSubtotal() {
        this.subtotal = item.getBasePrice() * quantity * (1 + ((float) item.getVatRate().getRate() / 100));
    }
}
