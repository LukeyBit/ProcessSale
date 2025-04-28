package view;

import controller.Controller;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        controller.startSale();
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
