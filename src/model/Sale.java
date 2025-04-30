package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sale {
    private LocalDateTime saleDateTime;
    private ArrayList<SoldItem> items;
    private float total;
    private float vat;
    private Discount discount;
    private float amountPaid;
    private float change;
    private Customer customer;

    public Sale() {
        this.items = new ArrayList<>();
        this.total = 0;
        this.vat = 0;
        this.discount = null;
        this.amountPaid = 0;
        this.change = 0;
        setDateTime();
    }

    public ArrayList<SoldItem> getItems() {
        return items;
    }

    public void addItem(Item item, int quantity) {
        for (SoldItem soldItem : items) {
            if (soldItem.getItem().getIdentifier() == item.getIdentifier()) {
                soldItem.addQuantity(quantity);
                return;
            }
        }
        items.add(new SoldItem(item, quantity));
    }

    public void removeItem(Item item, int quantity) {
        for (SoldItem soldItem : items) {
            if (soldItem.getItem().getIdentifier() == item.getIdentifier()) {
                if (soldItem.getQuantity() > quantity) {
                    soldItem.addQuantity(-quantity);
                } else {
                    items.remove(soldItem);
                }
                return;
            }
        }
    }

    public void pay(float payment) {
        amountPaid += payment;
        if (amountPaid >= total) {
            change = amountPaid - total;
            change = Math.round(change);
        }
    }

    public void createReceipt() {
        new Receipt(this);
    }

    private void setDateTime() {
        this.saleDateTime = LocalDateTime.now();
    }

    public LocalDateTime getSaleDateTime() {
        return saleDateTime;
    }

    public float getTotal() {
        setTotal();
        return total;
    }

    public float getVat() {
        setVat();
        return vat;
    }

    public float getChange() {
        return change;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
        setTotal();
    }

    public void setTotal() {
        this.total = 0;
        for (SoldItem soldItem : items) {
            this.total += soldItem.getSubtotal();
        }
        if (discount != null) {
            this.total -= discount.getItemsDiscount();
            this.total = this.total * (1 - (discount.getTotalDiscount()/100));
            this.total = this.total * (1 - (discount.getCustomerDiscount()/100));
        }
    }

    public void setVat() {
        this.vat = 0;
        for (SoldItem soldItem : items) {
            this.vat += soldItem.getItem().getBasePrice() * soldItem.getQuantity() * (soldItem.getItem().getVatRate().getRate())/100;
        }
    }
}
