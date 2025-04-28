package model;

public class Discount {
    private float itemsDiscount; // Discount amount to be removed from total
    private float totalDiscount; // Discount percentage to be removed from the total
    private float customerDiscount; // Discount percentage to be removed from the total for a specific customer

    public Discount(float itemsDiscount, float totalDiscount, float customerDiscount) {
        this.itemsDiscount = itemsDiscount;
        this.totalDiscount = totalDiscount;
        this.customerDiscount = customerDiscount;
    }

    public float getItemsDiscount() {
        return itemsDiscount;
    }

    public float getTotalDiscount() {
        return totalDiscount;
    }

    public float getCustomerDiscount() {
        return customerDiscount;
    }
}
