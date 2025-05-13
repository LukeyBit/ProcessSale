package controller;

import integration.*;
import model.Item;
import model.Sale;

/**
 * Controller.java
 * This class is responsible for managing the sale process, including starting and ending sales,
 * registering sales, entering payments, and fetching items and customers.
 * It interacts with the model and integration layers to perform its tasks.
 */
public class Controller {
    private float registerInventory;
    private Sale sale;

    /**
     * Constructor for the Controller class.
     * Initializes the register inventory to a default value.
     */
    public Controller() {
        this.registerInventory = 100f;
    }

    /**
     * Starts a new sale by creating a new Sale object.
     */
    public void startSale() {
        this.sale = new Sale();
    }

    /**
     * Ends the current sale by calculating the total, updating the register inventory,
     * creating a receipt, and registering the sale.
     */
    public void endSale() {
        sale.setTotal();
        this.registerInventory += sale.getTotal();
        Printer.print(sale.toDTO());
        registerSale();
    }

    /**
     * Registers the sale by reporting it to the accounting system and updating the inventory.
     */
    public void registerSale() {
        SaleDTO saleDTO = sale.toDTO();
        AccountingSystem.reportSale(saleDTO);
        InventorySystem.updateInventory(saleDTO.items());
    }

    /**
     * Enters a payment for the current sale.
     * @param payment The amount paid by the customer.
     */
    public void enterPayment(float payment) {
        sale.pay(payment);
    }

    /**
     * Enters an item into the current sale.
     * @param itemIdentifier The identifier of the item to be entered.
     * @param quantity The quantity of the item to be entered.
     *
     * @throws RuntimeException if the item is not found in the inventory system.
     * @throws IllegalArgumentException if the item identifier is invalid.
     */
    public Item enterItem(int itemIdentifier, int quantity) throws RuntimeException, IllegalArgumentException{
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        Item item = fetchItem(itemIdentifier);
        sale.addItem(item, quantity);
        return item;
    }

    /**
     * Fetches an item from the inventory system using its identifier.
     * @param itemIdentifier The identifier of the item to be fetched.
     * @return The item object fetched from the inventory system.
     *
     * @throws RuntimeException if the item is not found in the inventory system.
     * @throws IllegalArgumentException if the item identifier is invalid.
     */
    private Item fetchItem(int itemIdentifier) throws RuntimeException, IllegalArgumentException {
        return InventorySystem.getItem(itemIdentifier);
    }

    /**
     * Fetches a customer from the customer database using its identifier.
     * @param customerIdentifier The identifier of the customer to be fetched.
     */
    public void fetchCustomer(int customerIdentifier) {
         sale.setCustomer(CustomerDatabase.fetchCustomer(customerIdentifier));
    }

    /**
     * Fetches a discount for the current sale based on the items, total amount, and customer.
     * It updates the sale object with the fetched discount.
     */
    public void fetchDiscount() {
        sale.setDiscount(DiscountDatabase.fetchDiscount(sale.getItems(), sale.getTotal(), sale.getCustomer()));
    }

    /**
     * Gets the total of the current sale object.
     * @return The total of the current sale.
     */
    public float getTotal() {
        return sale.getTotal();
    }
}
