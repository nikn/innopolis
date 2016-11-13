package ru.innopolis.nikn.task1;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.nikn.utils.StreamUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Nikolay on 05.11.2016.
 */
public class PositiveSummerTest{
    IPositiveSummer positiveSummer;
    private static Logger log = LoggerFactory.getLogger(PositiveSummerTest.class);

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
        PositiveSummer positiveSummer =  spy(new PositiveSummer());
        when(positiveSummer.getStreamUtil()).thenReturn(streamUtil);
        this.positiveSummer = positiveSummer;
    }



    @Test
    public void testGetPositiveSumLocal() throws Exception {
        log.info("This is testGetPositiveSumLocal method");
        String[] resources = {
                "/test3/1.txt",
                "/test3/2.txt",
        };
        ShareBoxMonitor result = positiveSummer.getPositiveSum(resources);
        log.info("Result sum: {}.",result.getValue());
        assertTrue("Resources is incorrect.", result.isPredicate());
    }

    @Test
    public void testGetPositiveSumURL() throws Exception {
        log.info("This is testGetPositiveSumURL method");
        String[] resources = {
                "http://10.240.17.29/1.txt",
                "http://10.240.17.29/1.txt",
        };
        ShareBoxMonitor result = positiveSummer.getPositiveSum(resources);
        log.info("Result sum: {}.",result.getValue());
        assertTrue("Resources is incorrect.", result.isPredicate());
    }

    @Test
    public void testGetPositiveSumFail() throws Exception {
        log.info("This is testGetPositiveSumFail method");
        String[] resources = {
                "txt",
                "http:/",
        };
        ShareBoxMonitor result = positiveSummer.getPositiveSum(resources);
        log.info("Result sum: {}.",result.getValue());
        assertTrue("Resources is incorrect.", !result.isPredicate());
    }

    @After
    public void after(){
        log.info("This is @After method");
    }

    @AfterClass
    public static void afterTest(){
        log.info("This is @AfterClass method");
    }


    //@Test(expected = Exception.class) - not correct
    //@Ignore - крайне редко!

}