package controller.test;

import controller.Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ErrorHandlingTest.java
 * This class contains test cases for the error handling of the Controller class.
 * It verifies that appropriate exceptions are thrown for invalid inputs.
 */
public class ErrorHandlingTest {

    /**
     * This test case verifies that the IllegalArgumentException is thrown
     * when an invalid item quantity is entered.
     */
    @Test
    void testQuantityError() {
        Controller controller = new Controller();

        controller.startSale();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> controller.enterItem(1, -1));

        assertTrue(exception.getMessage().contains("Quantity must be greater than zero"), "Expected error message not found.");
    }

    /**
     * This test case verifies that the IllegalArgumentException is thrown
     * when an invalid item identifier is entered.
     */
    @Test
    void testItemNotFoundError() {
        Controller controller = new Controller();

        controller.startSale();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> controller.enterItem(999, 1));

        assertTrue(exception.getMessage().contains("Unknown item identifier: " + 999), "Expected error message not found.");
    }

    /**
     * This test case verifies that the RuntimeException is thrown
     * when the server is not active.
     */
    @Test
    void testServerError() {
        Controller controller = new Controller();

        controller.startSale();
        Exception exception = assertThrows(RuntimeException.class, () -> controller.enterItem(4, 1));

        assertTrue(exception.getMessage().contains("The server is not active"), "Expected error message not found.");
    }
}
