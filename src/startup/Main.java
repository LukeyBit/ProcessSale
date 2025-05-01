package startup;

import controller.Controller;
import view.View;

/**
* The main class for the Point of Sale (POS) system.
* It initializes the Controller and View classes to start the application.
*/
public class Main {
    private static View view;
    private static Controller controller;

    /**
     * The main method to start the POS system.
     * It creates instances of Controller and View to run the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        controller = new Controller();
        view = new View(controller);
    }
}