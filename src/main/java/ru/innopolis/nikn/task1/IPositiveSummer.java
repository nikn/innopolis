package ru.innopolis.nikn.task1;

import java.net.URL;

/**
 * Created by Nikolay on 04.11.2016.
 */
public interface IPositiveSummer {
    /**
     * Return positiveSummer
     * @param resources URL[]
     * @return ShareBoxMonitor
     * @throws InterruptedException
     */
    ShareBoxMonitor executeTest0(URL[] resources) throws InterruptedException;

    /**
     * Return positiveSummer
     * @param  resources URL[]
     * @return ShareBoxMonitor
     * @throws InterruptedException
     */
    ShareBoxMonitor executeTest1(URL[] resources) throws InterruptedException;

}
