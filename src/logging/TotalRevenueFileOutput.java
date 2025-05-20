package logging;

/**
 * TotalRevenueFileOutput.java
 * This class is responsible for logging total revenue messages to a specific file.
 * It extends the Logger class and provides a singleton instance for logging total revenue.
 */
public class TotalRevenueFileOutput extends Logger {
    private static TotalRevenueFileOutput instance;
    private static final String LOG_FILE_PATH = "total_revenue_log.txt";

    /**
     * Private constructor to prevent instantiation.
     */
    private TotalRevenueFileOutput() {
        super();
    }

    /**
     * Returns the singleton instance of TotalRevenueFileOutput.
     * If the instance is null, it creates a new instance.
     *
     * @return The singleton instance of TotalRevenueFileOutput.
     */
    public static TotalRevenueFileOutput getInstance() {
        if (instance == null) {
            instance = new TotalRevenueFileOutput();
        }
        return instance;
    }

    /**
     * Returns the path to the total revenue log file.
     * This method is overridden from the Logger class to provide the specific log file path.
     *
     * @return The path to the total revenue log file.
     */
    @Override
    protected String getLogFilePath() {
        return LOG_FILE_PATH;
    }
}
