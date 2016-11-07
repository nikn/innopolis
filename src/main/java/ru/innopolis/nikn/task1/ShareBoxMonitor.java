package ru.innopolis.nikn.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Nikolay on 04.11.2016.
 */
public class ShareBoxMonitor {
    /**
     * Sum result
     */
    private int value = 0;

    /**
     * Throw predicate
     */
    private boolean predicate = true;
    private static Logger logger;

    static {
        logger = Logger.getLogger(ShareBoxMonitor.class.getName());
    }

    /**
     * Get current sum value
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * Add positive value to sum
     * @param value int
     */
    public synchronized void addValue(int value) {
        if(value < 0) {
            return;
        }
        this.value += value;
        logger.info("Current value: " + this.value);
    }

    /**
     * Log error message, stop run treads
     * @param message
     */
    public synchronized void errorAction(String message) {
        logger.log(Level.SEVERE, "Exception: ", message);
        this.predicate = false;
    }

    /**
     * Get current predicate
     * @return predicate
     */
    public boolean isPredicate() {
        return predicate;
    }

}
