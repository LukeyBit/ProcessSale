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
