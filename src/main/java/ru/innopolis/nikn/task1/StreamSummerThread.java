package ru.innopolis.nikn.task1;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Created by Nikolay on 05.11.2016.
 */
public class StreamSummerThread extends Thread{

    private ShareBoxMonitor monitor;
    private Scanner stream;
    private static Logger logger = LoggerFactory.getLogger(StreamSummerThread.class);

    /**
     * Constructor StreamSummerThread
     * @param monitor ShareBoxMonitor
     * @param stream Scanner
     */
    StreamSummerThread(ShareBoxMonitor monitor, Scanner stream) {
        this.monitor = monitor;
        this.stream = stream;
    }

    @Override
    public void run() {
        MDC.put("threadName", this.getName());
        logger.info("RUN START.");
        while(monitor.isPredicate() && stream.hasNextInt()){
            monitor.addValue(stream.nextInt());
        }
        if(monitor.isPredicate() && stream.hasNext()) {
            monitor.errorAction(new RuntimeException("Incorrect data format: {}" + stream.next()));
            stream.close();
        }
        logger.info("RUN END.");
        MDC.clear();
    }
}
