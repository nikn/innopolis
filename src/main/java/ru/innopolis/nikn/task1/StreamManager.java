package ru.innopolis.nikn.task1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Nikolay on 05.11.2016.
 */
abstract public class StreamManager {

    /**
     * Return new stream Scanner from String path
     * @param path String
     * @return Scanner
     * @throws IOException
     */
    public static Scanner getScanner(String path) throws IOException{
        return new Scanner(new File(path));
    }


}
