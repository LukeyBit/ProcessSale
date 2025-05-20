package view;

import util.RevenueObserver;

public class TotalRevenueView implements RevenueObserver {
    private static TotalRevenueView instance;
    private static float totalRevenue;

    /**
     * Private constructor to prevent instantiation.
     */
    private TotalRevenueView() {
        totalRevenue = 0;
    }
    /**
     * Returns the singleton instance of TotalRevenueView.
     * If the instance is null, it creates a new instance.
     *
     * @return The singleton instance of TotalRevenueView.
     */
    public static TotalRevenueView getInstance() {
        if (instance == null) {
            instance = new TotalRevenueView();
        }
        return instance;
    }

    /**
     * Updates the total revenue and displays it.
     * This method is called when the revenue is updated.
     *
     * @param revenue The revenue to be added to the total.
     */
    @Override
    public void update(float revenue) {
        totalRevenue += revenue;
        System.out.println("Total Revenue: " + totalRevenue);
    }
}
