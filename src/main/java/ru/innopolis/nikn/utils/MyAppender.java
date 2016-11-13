package ru.innopolis.nikn.utils;

import org.apache.log4j.FileAppender;

import java.io.IOException;

/**
 * Created by Nikolay on 10.11.2016.
 */
public class MyAppender extends FileAppender {
    public synchronized void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize)
            throws IOException {
        super.setFile(fileName, false, bufferedIO, bufferSize);
    }

}
