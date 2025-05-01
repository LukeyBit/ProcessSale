package model;

/**
 * The Item class represents an item in the Point of Sale (POS) system.
 * It contains information about the item's identifier, name, description, base price, and VAT rate.
 */
public class Item {
    private int identifier;
    private String name;
    private String description;
    private float basePrice;
    private VatRate vatRate;

    /**
     * Constructor for the Item class.
     * Initializes the item with its identifier, name, description, base price, and VAT rate.
     *
     * @param identifier  The unique identifier for the item.
     * @param name        The name of the item.
     * @param description A brief description of the item.
     * @param basePrice   The base price of the item.
     * @param vatRate     The VAT rate applicable to the item.
     */
    public Item(int identifier, String name, String description, float basePrice, VatRate vatRate) {
        this.identifier = identifier;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.vatRate = vatRate;
    }

    /**
     * Gets the unique identifier for the item.
     *
     * @return The unique identifier for the item.
     */
    public int getIdentifier() {
        return identifier;
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the base price of the item.
     *
     * @return The base price of the item.
     */
    public float getBasePrice() {
        return basePrice;
    }

    /**
     * Gets the VAT rate applicable to the item.
     *
     * @return The VAT rate applicable to the item.
     */
    public VatRate getVatRate() {
        return vatRate;
    }
}
