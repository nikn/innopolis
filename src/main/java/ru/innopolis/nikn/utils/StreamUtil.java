package ru.innopolis.nikn.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.nikn.task1.ShareBoxMonitor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Nikolay on 13.11.2016.
 */
public class StreamUtil {

    private static Logger logger = LoggerFactory.getLogger(StreamUtil.class);

    public StreamUtil() {

    }

    /**
     * Validate file Path
     * @param filePath String
     * @return boolean
     */
    public static boolean validateFilePath(String filePath) {
        try {
            Paths.get(filePath);
            logger.info("Validate local file path {}.", filePath);
        } catch (InvalidPathException ex) {
            try {
                new URL(filePath);
                logger.info("Validate URL file path {}.", filePath);
            } catch (MalformedURLException e) {
                logger.info("Validate file path:{} ,error {}.", filePath, e);
                return false;
            }
        }
        return true;
    }

    /**
     * Return URL from local file path
     * @param path String
     * @return URL
     */
    private URL getURLFromLocal(String path) {
        return getClass().getResource(path);
    }

    /**
     * Return URL from URL file path
     * @param path String
     * @return URL
     */
    private URL getURL(String path) throws MalformedURLException {
        return new URL(path);
    }

    /**
     * Create Input stream from file path
     * @param filePath String
     * @return InputStream
     * @throws IOException
     */
    private InputStream createInputStream(String filePath) throws IOException {
        try {
            URL url = getURLFromLocal(filePath);
            if(url == null) {
                url = getURL(filePath);
            }
            return url.openStream();
        }
        catch (IOException ex) {
            logger.error("Create input stream from: {} fail. ", filePath, ex);
            throw ex;
        }
    }

    /**
     * Return Input stream from file path
     * @param filePath String
     * @return InputStream
     * @throws IOException
     */
    public InputStream getInputStream(String filePath) throws IOException {
        boolean validate = validateFilePath(filePath);
        if(!validate) {
            throw new IOException("Incorrect file path: " + filePath);
        }
        return createInputStream(filePath);
    }

    /**
     * Return Scanner from InputStream
     * @param inputStream InputStream
     * @return Scanner
     */
    public Scanner getScanner(InputStream inputStream) {
        return new Scanner(inputStream);
    }


    /**
     * Return Scanner from String file path
     * @param filePath String
     * @return Scanner
     */
    public Scanner getScanner(String filePath) throws IOException {
        return new Scanner(getInputStream(filePath));
    }

}
