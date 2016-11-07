package ru.innopolis.nikn.task1;

import java.util.Scanner;

/**
 * Created by Nikolay on 05.11.2016.
 */
public class StreamSummerThread extends Thread{

    private ShareBoxMonitor monitor;
    private Scanner stream;

    /**
     * Constructor StreamSummerThread
     * @param ShareBoxMonitor monitor
     * @param Scanner stream
     */
    StreamSummerThread(ShareBoxMonitor monitor, Scanner stream) {
        this.monitor = monitor;
        this.stream = stream;
    }

    @Override
    public void run() {
        while(monitor.isPredicate() && stream.hasNextInt()){
            monitor.addValue(stream.nextInt());
        }
        if(monitor.isPredicate() && stream.hasNext()) {
            stream.close();
            monitor.errorAction("Incorrectly data format.");
            throw new RuntimeException("Incorrectly data format.");
        }
        return;
    }
}
