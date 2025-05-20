package exception;

/**
 * InvalidIdentifierException.java
 * This class represents an exception that is thrown when an invalid identifier is encountered.
 * It extends the Exception class and provides several constructors for different use cases.
 */
public class InvalidIdentifierException extends Exception {
    /**
     * Default constructor.
     */
    public InvalidIdentifierException() {
    }

    /**
     * Constructor with a message parameter.
     *
     * @param message The detail message for the exception.
     */
    public InvalidIdentifierException(String message) {
        super(message);
    }

    /**
     * Constructor with message and cause parameters.
     *
     * @param message The detail message for the exception.
     * @param cause   The cause of the exception.
     */
    public InvalidIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause parameter.
     *
     * @param cause The cause of the exception.
     */
    public InvalidIdentifierException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor with message, cause, enableSuppression, and writableStackTrace parameters.
     *
     * @param message            The detail message for the exception.
     * @param cause              The cause of the exception.
     * @param enableSuppression  Whether suppression is enabled.
     * @param writableStackTrace Whether the stack trace is writable.
     */
    public InvalidIdentifierException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
