package ru.innopolis.nikn.utils;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Nikolay on 13.11.2016.
 */
public class StreamUtilTest {

    StreamUtil streamUtil;

    private static Logger log = LoggerFactory.getLogger(StreamUtilTest.class);

    @BeforeClass
    public static void beforeTest(){
        log.info("This is @BeforeClass method");
    }


    @Before
    public void before() throws IOException {
        log.info("This is @Before method");
        String[] resources = {
                "/test3/1.txt",
                "/test3/2.txt",
                "http://10.240.17.29/1.txt",
                "http://10.240.17.29/2.txt"
        };
        StreamUtil streamUtil =  spy(new StreamUtil());
        String dataOne = "1 3 5 7";
        String dataTwo = "2 4 6 8";
        InputStream streamOne = new ByteArrayInputStream(dataOne.getBytes());
        InputStream streamTwo = new ByteArrayInputStream(dataTwo.getBytes());
        doReturn(streamOne).when(streamUtil).getInputStream(resources[0]);
        doReturn(streamTwo).when(streamUtil).getInputStream(resources[1]);
        doReturn(streamOne).when(streamUtil).getInputStream(resources[2]);
        doReturn(streamTwo).when(streamUtil).getInputStream(resources[3]);
        this.streamUtil = streamUtil;
    }

    @Test
    public void testValidateFilePathLocal() throws Exception {
        String filePath = "/test3/1.txt";
        assertTrue("Validate Local error: " + filePath, StreamUtil.validateFilePath(filePath));
    }

    @Test
    public void testValidateFilePathURL() throws Exception {
        String filePath = "http://10.240.17.29/1.txt";
        assertTrue("Validate URL error: " + filePath, StreamUtil.validateFilePath(filePath));
    }

    @Test
    public void testValidateFilePathFail() throws Exception {
        String filePath = "not|good.txt";
        assertTrue("Validate Fail error: " + filePath, !StreamUtil.validateFilePath(filePath));
    }

    @Test
    public void testGetScannerByStream() {
        String dataOne = "1 3 5 7";
        InputStream streamOne = new ByteArrayInputStream(dataOne.getBytes());
        streamUtil.getScanner(streamOne);
    }

    @Test(expected = Exception.class)
    public void testGetScannerByStreamFail() {
        InputStream inputStream = null;
        streamUtil.getScanner(inputStream);
    }


    @Test
    public void testGetScannerByFilePathLocal() throws IOException {
        String filePath = "/test3/1.txt";
        streamUtil.getScanner(filePath);
    }

    @Test
    public void testGetScannerByFilePathURL() throws IOException {
        String filePath = "http://10.240.17.29/1.txt";
        streamUtil.getScanner(filePath);
    }

    @Test(expected = Exception.class)
    public void testGetScannerByFilePathFail() throws IOException {
        String filePath = "://100.240.170.29/1.txt";
        streamUtil.getScanner(filePath);
    }

    @After
    public void after(){
        log.info("This is @After method");
    }

    @AfterClass
    public static void afterTest(){
        log.info("This is @AfterClass method");
    }
}
