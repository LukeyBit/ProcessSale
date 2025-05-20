package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logger.java
 * This class is responsible for logging messages to a file.
 * It provides methods to log messages and handle file writing.
 */
public abstract class Logger {
    private PrintWriter writer;

    /**
     * Constructor for the Logger class.
     * Initializes the PrintWriter to write to the specified log file.
     */
    public Logger() {
        try {
            writer = new PrintWriter(new FileWriter(getLogFilePath(), true));
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    /**
     * Returns the path to the log file.
     * This method should be overridden by subclasses to provide the specific log file path.
     *
     * @return The path to the log file.
     */
    protected abstract String getLogFilePath();

    /**
     * Logs a message to the log file.
     *
     * @param message The message to log.
     */
    public void log(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush();
        } else {
            System.err.println("Logger not initialized.");
        }
    }
}
