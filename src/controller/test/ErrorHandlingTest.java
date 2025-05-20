package controller.test;

import controller.Controller;

import exception.InvalidIdentifierException;
import exception.ServerOfflineException;
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
     * This test case verifies that the InvalidIdentifierException is thrown
     * when an invalid item identifier is entered.
     */
    @Test
    void testItemNotFoundError() {
        Controller controller = new Controller();

        controller.startSale();
        Exception exception = assertThrows(InvalidIdentifierException.class, () -> controller.enterItem(999, 1));

        assertTrue(exception.getMessage().contains("Unknown item identifier: " + 999), "Expected error message not found.");
    }

    /**
     * This test case verifies that the ServerOfflineException is thrown
     * when the server is not active.
     */
    @Test
    void testServerError() {
        Controller controller = new Controller();

        controller.startSale();
        Exception exception = assertThrows(ServerOfflineException.class, () -> controller.enterItem(4, 1));

        assertTrue(exception.getMessage().contains("Server is offline"), "Expected error message not found.");
    }
}
