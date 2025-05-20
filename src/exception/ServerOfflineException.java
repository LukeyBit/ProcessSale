package exception;

/**
 * ServerOfflineException.java
 * This class represents an exception that is thrown when the server is offline.
 * It extends the Exception class and provides several constructors for different use cases.
 */
public class ServerOfflineException extends Exception {
    /**
     * Default constructor.
     */
    public ServerOfflineException() {
    }

    /**
     * Constructor with a message parameter.
     *
     * @param message The detail message for the exception.
     */
    public ServerOfflineException(String message) {
        super(message);
    }

    /**
     * Constructor with message and cause parameters.
     *
     * @param message The detail message for the exception.
     * @param cause   The cause of the exception.
     */
    public ServerOfflineException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause parameter.
     *
     * @param cause The cause of the exception.
     */
    public ServerOfflineException(Throwable cause) {
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
    public ServerOfflineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
