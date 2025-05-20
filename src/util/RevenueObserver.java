package util;

/**
 * RevenueObserver.java
 * This interface defines the methods for an observer that receives updates about revenue changes.
 * It allows the observer to be notified with the updated revenue.
 */
public interface RevenueObserver {

    /**
     * Updates the observer with the given revenue.
     * This method is called when the revenue is updated.
     *
     * @param revenue The revenue to be passed to the observer.
     */
    void update(float revenue);
}
