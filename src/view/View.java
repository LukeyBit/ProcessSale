package view;

import controller.Controller;
import logging.Logger;

import java.util.Scanner;

/**
 * The View class represents the user interface of the Point of Sale (POS) system.
 * It interacts with the cashier to scan items, add customers, and process payments.
 */
public class View {
    private Controller controller;

    /**
     * Constructor for the View class.
     * Takes a Controller object to interact with the system.
     * Initializes the sale and prompts the user for input.
     *
     * @param controller The Controller object to interact with the system.
     */
    public View(Controller controller) {
        this.controller = controller;
        controller.startSale();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the POS system!");
        System.out.println("Please scan items, add customer, and make payment.");

        System.out.println("Enter item identifier and quantity (e.g., 1 2):");

        while (scanner.hasNextInt()) {
            int itemIdentifier = scanner.nextInt();
            int quantity = scanner.nextInt();

            if (scanItem(itemIdentifier, quantity)) {
                System.out.println("Item scanned. The total is now: " + controller.getTotal() + " SEK. Enter next item or 'done' to finish:");
            } else {
                System.out.println("Please enter a valid item identifier and quantity:");
            }
        }

        scanner.nextLine();
        scanner.nextLine();

        System.out.println("Enter customer identifier (or -1 if no customer):");
        int customerInput = scanner.nextInt();

        if (customerInput != -1) {
            addCustomer(customerInput);
        }

        controller.fetchDiscount();

        System.out.println("The total is now: " + controller.getTotal() + " SEK.");
        System.out.println("Enter payment amount:");

        float payment = scanner.nextFloat();
        pay(payment);
        System.out.println("Payment received. The total is now: " + controller.getTotal() + " SEK.\n");

        endSale();
    }

    /**
     * Scans an item and adds it to the sale.
     *
     * @param itemIdentifier The identifier of the item to be scanned.
     * @param quantity The quantity of the item to be scanned.
     *
     * @return true if the item was successfully scanned, false otherwise.
     */
    public boolean scanItem(int itemIdentifier, int quantity) {
        try {
            controller.enterItem(itemIdentifier, quantity);
            return true;
        } catch (IllegalArgumentException e) {
            new Logger().log(e.getMessage());
            return false;
        } catch (RuntimeException e) {
            new Logger().log(e.getMessage());
            System.out.println("!!! Server is not active. Please try again later. !!!");
            return false;
        }
    }

    /**
     * Adds a customer to the sale.
     *
     * @param customerIdentifier The identifier of the customer to be added.
     */
    public void addCustomer(int customerIdentifier) {
        controller.fetchCustomer(customerIdentifier);
    }

    /**
     * Processes the payment for the sale.
     *
     * @param payment The amount of payment to be processed.
     */
    public void pay(float payment) {
        controller.enterPayment(payment);
    }

    /**
     * Ends the sale by calling the controller's endSale method.
     */
    public void endSale() {
        controller.endSale();
    }
}
