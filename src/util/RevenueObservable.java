package util;


/**
 * RevenueObservable.java
 * This interface defines the methods for an observable object that notifies observers about revenue changes.
 * It allows observers to be added, removed, and notified with the updated revenue.
 */
public interface RevenueObservable {

    /**
     * Adds an observer to the list of observers.
     *
     * @param revenueObserver The observer to be added.
     */
    void addObserver(RevenueObserver revenueObserver);

    /**
     * Removes an observer from the list of observers.
     *
     * @param revenueObserver The observer to be removed.
     */
    void removeObserver(RevenueObserver revenueObserver);

    /**
     * Notifies all observers with the given revenue.
     *
     * @param revenue The revenue to be passed to the observers.
     */
    void notifyObservers(float revenue);
}
