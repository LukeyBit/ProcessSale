package model;

public class Item {
    private int identifier;
    private String name;
    private String description;
    private float basePrice;
    private VatRate vatRate;

    public Item(int identifier, String name, String description, float basePrice, VatRate vatRate) {
        this.identifier = identifier;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.vatRate = vatRate;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public VatRate getVatRate() {
        return vatRate;
    }
}
