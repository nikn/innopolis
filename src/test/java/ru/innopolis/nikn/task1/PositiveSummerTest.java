package ru.innopolis.nikn.task1;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.net.URL;

/**
 * Created by Nikolay on 05.11.2016.
 */
public class PositiveSummerTest extends TestCase{
    IPositiveSummer positiveSummer;

    public static junit.framework.Test suite()
    {
        return new TestSuite( PositiveSummerTest.class );
    }

    public void setUp() throws Exception {
        positiveSummer = new PositiveSummer();
        super.setUp();
    }
    public void test0() throws Exception {
        URL[] resources = {
                getClass().getResource("/test0/1.txt"),
                getClass().getResource("/test0/2.txt"),
        };
        ShareBoxMonitor result = positiveSummer.executeTest0(resources);
        System.out.println(result.getValue());
        assertEquals("Runtime error", result.isPredicate(), result.getValue() >= 0);
    }

    public void test1() throws Exception {
        URL[] resources = {
                getClass().getResource("/test1/1.txt"),
                getClass().getResource("/test1/2.txt"),
        };
        ShareBoxMonitor result = positiveSummer.executeTest0(resources);
        System.out.println(result.getValue());
        assertEquals("Runtime error", result.isPredicate(), result.getValue() >= 0);
    }

}