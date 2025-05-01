package model;

/**
 * The Discount class represents a discount applied to a sale in the Point of Sale (POS) system.
 * It contains information about the discount amount, total discount percentage, and customer-specific discount percentage.
 */
public class Discount {
    private float itemsDiscount; // Discount amount to be removed from total
    private float totalDiscount; // Discount percentage to be removed from the total
    private float customerDiscount; // Discount percentage to be removed from the total for a specific customer

    /**
     * Constructor for the Discount class.
     * Initializes the discount amounts and percentages.
     *
     * @param itemsDiscount    The discount amount to be removed from total.
     * @param totalDiscount    The discount percentage to be removed from the total.
     * @param customerDiscount The discount percentage to be removed from the total for a specific customer.
     */
    public Discount(float itemsDiscount, float totalDiscount, float customerDiscount) {
        this.itemsDiscount = itemsDiscount;
        this.totalDiscount = totalDiscount;
        this.customerDiscount = customerDiscount;
    }

    /**
     * Gets the discount amount to be removed from total.
     * @return The discount amount to be removed from total.
     */
    public float getItemsDiscount() {
        return itemsDiscount;
    }

    /**
     * Gets the discount percentage to be removed from the total.
     * @return The discount percentage to be removed from the total.
     */
    public float getTotalDiscount() {
        return totalDiscount;
    }

    /**
     * Gets the discount percentage to be removed from the total for a specific customer.
     * @return The discount percentage to be removed from the total for a specific customer.
     */
    public float getCustomerDiscount() {
        return customerDiscount;
    }
}
