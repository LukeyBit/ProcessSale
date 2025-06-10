package logging;

import util.RevenueObserver;

/**
 * TotalRevenueFileOutput.java
 * This class is responsible for logging total revenue messages to a specific file.
 * It extends the Logger class and provides a singleton instance for logging total revenue.
 */
public class TotalRevenueFileOutput extends Logger implements RevenueObserver {
    private static TotalRevenueFileOutput instance;
    private static final String LOG_FILE_PATH = "total_revenue_log.txt";
    private static float totalRevenue;

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

    /**
     * Updates the total revenue and logs the message.
     * This method is called when the revenue is updated.
     *
     * @param revenue The revenue to be added to the total.
     */
    @Override
    public void update(float revenue) {
        totalRevenue += revenue;
        String message = "Total Revenue: " + totalRevenue;
        log(message);
    }
}
