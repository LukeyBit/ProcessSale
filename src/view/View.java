package view;

import controller.Controller;

import java.util.Scanner;

public class View {
    private Controller controller;

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
            scanItem(itemIdentifier, quantity);
            System.out.println("Item scanned. The total is now: " + controller.getTotal() + " SEK. Enter next item or 'done' to finish:");
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

    public void scanItem(int itemIdentifier, int quantity) {
        controller.enterItem(itemIdentifier, quantity);
    }

    public void addCustomer(int customerIdentifier) {
        controller.fetchCustomer(customerIdentifier);
    }

    public void pay(float payment) {
        controller.enterPayment(payment);
    }

    public void endSale() {
        controller.endSale();
    }
}
