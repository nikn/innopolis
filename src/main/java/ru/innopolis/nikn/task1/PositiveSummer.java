package ru.innopolis.nikn.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.nikn.utils.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Nikolay on 04.11.2016.
 */
public class PositiveSummer implements IPositiveSummer {

    private ShareBoxMonitor monitor;

    private List<Thread> threads;

    private ShareBoxMonitor getMonitor() {
        return this.monitor;
    }

    private void setMonitor(ShareBoxMonitor monitor) {
        this.monitor = monitor;
    }

    private List<Thread> getThreads() {
        return threads;
    }

    private void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    public StreamUtil getStreamUtil(){
        return new StreamUtil();
    }

    @Override
    public ShareBoxMonitor getPositiveSum(String[] resources) {
        this.setMonitor(new ShareBoxMonitor());
        this.setThreads(new LinkedList<Thread>());
        createThreads(resources);
        joinThreads();
        return getMonitor();
    }

    private void joinThreads() {
        for(Thread thread: getThreads()) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                getMonitor().errorAction(ex);
            }
        }
    }

    private void createThreads(String[] resources) {
        StreamUtil streamUtil = getStreamUtil();
        for(String resource: resources) {
            try {
                Thread thread = getStreamSummerThread(streamUtil, resource);
                thread.start();
                getThreads().add(thread);
            }
            catch (Exception ex) {
                getMonitor().errorAction(ex);
            }
        }
    }

    private Thread getStreamSummerThread(StreamUtil streamUtil, String resource) throws IOException {
       return  new StreamSummerThread(getMonitor(), streamUtil.getScanner(resource));
    }

}

