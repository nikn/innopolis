package ru.innopolis.nikn.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Nikolay on 04.11.2016.
 */
public class ShareBoxMonitor implements IShareBoxMonitor{
    /**
     * Sum result
     */
    private int value = 0;

    /**
     * Throw predicate
     */
    private boolean predicate = true;
    private static Logger logger = LoggerFactory.getLogger(ShareBoxMonitor.class);

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public synchronized void addValue(int value) {
        if(value < 0) {
            return;
        }
        this.value += value;
        logger.info("Current value: {}", this.value);
    }

    @Override
    public synchronized void errorAction(Exception ex) {
        logger.error("Exception: {}", ex);
        this.predicate = false;
    }

    @Override
    public boolean isPredicate() {
        return predicate;
    }

}
