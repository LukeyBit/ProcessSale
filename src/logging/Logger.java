package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logger.java
 * This class is responsible for logging messages to a file.
 * It provides methods to log messages and handle file writing.
 */
public class Logger{
    private final String logFilePath = "log.txt";
    private PrintWriter writer;

    /**
     * Constructor for the Logger class.
     * Initializes the PrintWriter to write to the specified log file.
     */
    public Logger() {
        try {
            writer = new PrintWriter(new FileWriter(logFilePath, true));
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    /**
     * Logs a message to the log file.
     *
     * @param message
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
