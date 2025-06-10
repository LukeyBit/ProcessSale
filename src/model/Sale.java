package model;

import integration.SaleDTO;
import util.RevenueObservable;
import util.RevenueObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * The Sale class represents a sale transaction in the Point of Sale (POS) system.
 * It contains information about the items sold, total amount, VAT, discount, payment, and customer.
 */
public class Sale implements RevenueObservable {
    private LocalDateTime saleDateTime;
    private ArrayList<SoldItem> items;
    private float total;
    private float vat;
    private Discount discount;
    private float amountPaid;
    private float change;
    private Customer customer;
    private ArrayList<RevenueObserver> observers = new ArrayList<>();

    /**
     * Constructor for the Sale class.
     * Initializes the items list, total amount, VAT, discount, payment, and change.
     */
    public Sale(RevenueObserver[] revObservers) {
        this.items = new ArrayList<>();
        this.total = 0;
        this.vat = 0;
        this.discount = null;
        this.amountPaid = 0;
        this.change = 0;
        setDateTime();

        for (RevenueObserver observer : revObservers) {
            addObserver(observer);
        }
    }

    /**
     * Gets the list of items sold in the sale.
     *
     * @return The list of items sold in the sale.
     */
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

    /**
     * Removes a specified quantity of an item from the sale.
     * If the quantity to remove is greater than the current quantity, the item is removed from the sale.
     *
     * @param item     The item to remove.
     * @param quantity The quantity to remove.
     */
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

    /**
     * Adds a payment to the sale.
     * If the payment exceeds the total amount, the change is calculated.
     *
     * @param payment The payment amount.
     */
    public void pay(float payment) {
        amountPaid += payment;
        if (amountPaid >= total) {
            change = amountPaid - total;
            change = Math.round(change);
        }
        notifyObservers(total);
    }

    /**
     * Sets the sale date and time to the current date and time.
     * This method is called when the sale is created.
     */
    private void setDateTime() {
        this.saleDateTime = LocalDateTime.now();
    }

    /**
     * Gets the date and time of the sale.
     *
     * @return The date and time of the sale.
     */
    public LocalDateTime getSaleDateTime() {
        return saleDateTime;
    }

    /**
     * Gets the total amount of the sale.
     *
     * @return The total amount of the sale.
     */
    public float getTotal() {
        setTotal();
        return total;
    }

    /**
     * Gets the VAT amount of the sale.
     *
     * @return The VAT amount of the sale.
     */
    public float getVat() {
        setVat();
        return vat;
    }

    /**
     * Gets the discount applied to the sale.
     *
     * @return The discount applied to the sale.
     */
    public float getChange() {
        return change;
    }

    /**
     * Gets the amount paid for the sale.
     *
     * @return The amount paid for the sale.
     */
    public float getAmountPaid() {
        return amountPaid;
    }

    /**
     * Gets the customer associated with the sale.
     *
     * @return The customer associated with the sale.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with the sale.
     * This method is called when a customer is added to the sale.
     *
     * @param customer The customer to be associated with the sale.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Sets the discount applied to the sale.
     * This method is called when a discount is applied to the sale.
     *
     * @param discount The discount to be applied to the sale.
     */
    public void setDiscount(Discount discount) {
        this.discount = discount;
        setTotal();
    }

    /**
     * Sets the total amount of the sale based on the items sold and any discounts applied.
     * This method is called when calculating the total amount of the sale.
     */
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

    /**
     * Sets the VAT amount of the sale based on the items sold.
     * This method is called when calculating the VAT amount of the sale.
     */
    public void setVat() {
        this.vat = 0;
        for (SoldItem soldItem : items) {
            this.vat += soldItem.getItem().getBasePrice() * soldItem.getQuantity() * (soldItem.getItem().getVatRate().getRate())/100;
        }
    }

    public boolean isCompleted() {
        return amountPaid >= total;
    }

    public SaleDTO toDTO() {
        setTotal();
        setVat();
        return new SaleDTO(saleDateTime, items.stream().map(SoldItem::toDTO).toList(), total, vat, discount, amountPaid, change, customer);
    }

    /**
     * Adds an observer to the list of observers.
     *
     * @param revenueObserver The observer to be added.
     */
    @Override
    public void addObserver(RevenueObserver revenueObserver) {
        if (revenueObserver != null && !observers.contains(revenueObserver)) {
            observers.add(revenueObserver);
        }
    }

    /**
     * Removes an observer from the list of observers.
     *
     * @param revenueObserver The observer to be removed.
     */
    @Override
    public void removeObserver(RevenueObserver revenueObserver) {
        if (revenueObserver != null) {
            observers.remove(revenueObserver);
        }
    }

    /**
     * Notifies all observers with the given revenue.
     *
     * @param revenue The revenue to be passed to the observers.
     */
    @Override
    public void notifyObservers(float revenue) {
        for (RevenueObserver observer : observers) {
            observer.update(revenue);
        }
    }
}
