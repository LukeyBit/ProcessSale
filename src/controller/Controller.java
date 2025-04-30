package controller;

import integration.*;
import model.Item;
import model.Sale;

public class Controller {
    private float registerInventory;
    private Sale sale;

    public Controller() {
        this.registerInventory = 100f;
    }

    public void startSale() {
        this.sale = new Sale();
    }

    public void endSale() {
        sale.setTotal();
        this.registerInventory += sale.getTotal();
        sale.createReceipt();
        registerSale();
    }

    public void registerSale() {
        new AccountingSystem().reportSale(sale);
        new InventorySystem().updateInventory(sale.getItems());
    }

    public void enterPayment(float payment) {
        sale.pay(payment);
    }

    public void enterItem(int itemIdentifier, int quantity) {
        sale.addItem(fetchItem(itemIdentifier), quantity);
    }

    private Item fetchItem(int itemIdentifier) {
         return new InventorySystem().getItem(itemIdentifier);
    }

    public void fetchCustomer(int customerIdentifier) {
         sale.setCustomer(new CustomerDatabase().fetchCustomer(customerIdentifier));
    }

    public void fetchDiscount() {
        sale.setDiscount(new DiscountDatabase().fetchDiscount(sale.getItems(), sale.getTotal(), sale.getCustomer()));
    }

    public float getTotal() {
        return sale.getTotal();
    }
}
