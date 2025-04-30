package model;

public class SoldItem {
    private Item item;
    private int quantity;
    private float subtotal;

    public SoldItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        setSubtotal();
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
        this.subtotal = item.getBasePrice() * this.quantity;
        setSubtotal();
    }

    public float getSubtotal() {
        return subtotal;
    }

    private void setSubtotal() {
        this.subtotal = item.getBasePrice() * quantity * (1 + ((float) item.getVatRate().getRate() / 100));
    }
}
