package ru.innopolis.nikn.task1;

/**
 * Created by Nikolay on 11.11.2016.
 */
public interface IShareBoxMonitor {

    /**
     * Get current sum value
     * @return value int
     */
    public long getValue();
    /**
     * Add positive value to sum
     * @param value int
     */
    public void addValue(int value);

    /**
     * Log error message, stop run treads.
     * @param ex Exception
     */
    public void errorAction(Exception ex);

    /**
     * Get current predicate
     * @return predicate
     */
    public boolean isPredicate();

}
