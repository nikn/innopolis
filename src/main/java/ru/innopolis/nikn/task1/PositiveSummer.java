package ru.innopolis.nikn.task1;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Nikolay on 04.11.2016.
 */
public class PositiveSummer implements IPositiveSummer{
    private static Logger logger;

    static {
        logger = Logger.getLogger(ShareBoxMonitor.class.getName());
    }

    /**
     * Return positive sum in share resource - ShareBoxMonitor
     * @param resources URL[]
     * @return ShareBoxMonitor
     * @throws InterruptedException
     */
    private ShareBoxMonitor getPositiveSum(URL[] resources) throws InterruptedException {
        ShareBoxMonitor monitor = new ShareBoxMonitor();
        List<Thread> threads = new LinkedList<>();
        for(URL resource: resources) {
            try {
                Thread thread = new StreamSummerThread(monitor, StreamManager.getScanner(resource.getPath()));
                thread.start();
                threads.add(thread);
                logger.log(Level.INFO, "Start tread: " + thread.getName() + " for: " + resource);
            }
            catch (Exception e) {
                monitor.errorAction("Tread create error: "+ e);
                logger.log(Level.SEVERE, "Exception: ", e);
            }
        }
        for(Thread thread: threads) {
            thread.join();
        }
        return monitor;
    }

    @Override
    public ShareBoxMonitor executeTest0(URL[] resources) throws InterruptedException {
        return getPositiveSum(resources);
    }

    @Override
    public ShareBoxMonitor executeTest1(URL[] resources) throws InterruptedException {
        return getPositiveSum(resources);
    }

}

