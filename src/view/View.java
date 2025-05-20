package view;

import controller.Controller;
import exception.InvalidIdentifierException;
import exception.ServerOfflineException;
import logging.ErrorFileOutput;
import model.Item;

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the POS system!");
        System.out.println("Please scan items, add customer, and make payment.");

        do {
            controller.startSale();
            boolean scanningItems = true;
            do {
                System.out.println("Enter item identifier and quantity (e.g., 1 2) or \"Done\" to finish:");

                if (scanner.hasNextInt()) {
                    int itemIdentifier = scanner.nextInt();
                    int quantity = scanner.nextInt();

                    try {
                        Item item = scanItem(itemIdentifier, quantity);
                        System.out.println("Scanned item: " + item.getName() + ", Price: " + item.getBasePrice() + "\n" + item.getDescription() + "\nThe total is now: " + controller.getTotal() + " SEK.");
                    } catch (Exception e) {
                        ErrorFileOutput.getInstance().log(e.getMessage());
                        System.out.println(e.getMessage());
                        System.out.println("Please try again.");
                    }
                } else {
                    for (int i = 0; i < 2; i++) {
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("done")) {
                            System.out.println("Finished scanning items.");
                            scanningItems = false;
                        }
                    }
                    if (scanningItems) {
                        System.out.println("Invalid input. Please enter item identifier and quantity (e.g., 1 2) or \"Done\" to finish:");
                    }
                }
            } while (scanningItems);

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

            System.out.println("\nSale completed. To start a new sale, type \"New\" or \"Quit\" to exit.");
            scanner.nextLine();
        } while (!scanner.nextLine().equalsIgnoreCase("quit"));
    }

    /**
     * Scans an item and adds it to the sale.
     *
     * @param itemIdentifier The identifier of the item to be scanned.
     * @param quantity The quantity of the item to be scanned.
     *
     * @return The scanned item.
     */
    public Item scanItem(int itemIdentifier, int quantity) throws ServerOfflineException, InvalidIdentifierException {
            return controller.enterItem(itemIdentifier, quantity);
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
