package logging;

/**
 * ErrorFileOutput.java
 * This class is responsible for logging error messages to a specific file.
 * It extends the Logger class and provides a singleton instance for logging errors.
 */
public class ErrorFileOutput extends Logger {
    private static ErrorFileOutput instance;
    private static final String LOG_FILE_PATH = "error_log.txt";

    /**
     * Private constructor to prevent instantiation.
     */
    private ErrorFileOutput() {
        super();
    }

    /**
     * Returns the singleton instance of ErrorFileOutput.
     * If the instance is null, it creates a new instance.
     *
     * @return The singleton instance of ErrorFileOutput.
     */
    public static ErrorFileOutput getInstance() {
        if (instance == null) {
            instance = new ErrorFileOutput();
        }
        return instance;
    }

    /**
     * Returns a formatted string containing the exception details.
     * This method is used to log exception messages in a readable format.
     * @param e The exception to log.
     *
     * @return A formatted string containing the exception class name, message, and stack trace.
     */
    public static String getExceptionLogMessage(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Exception: ").append(e.getClass().getName()).append("\n");
        sb.append("Message: ").append(e.getMessage()).append("\n");
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append("\tat ").append(element.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns the path to the error log file.
     * This method is overridden from the Logger class to provide the specific log file path.
     *
     * @return The path to the error log file.
     */
    @Override
    protected String getLogFilePath() {
        return LOG_FILE_PATH;
    }
}
