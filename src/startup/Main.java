package startup;

import controller.Controller;
import view.View;

public class Main {
    private static View view;
    private static Controller controller;

    public static void main(String[] args) {
        controller = new Controller();
        view = new View(controller);
    }
}