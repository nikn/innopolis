package ru.innopolis.nikn.task1;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by Nikolay on 11.11.2016.
 */
public class ShareBoxMonitorTest {
    IShareBoxMonitor shareBoxMonitor;
    private static Logger log = LoggerFactory.getLogger(ShareBoxMonitorTest.class);

    @BeforeClass
    public static void beforeTest(){
        log.info("This is @BeforeClass method");
    }

    @Before
    public void before(){
        log.info("This is @Before method");
        this.shareBoxMonitor = new ShareBoxMonitor();
    }

    @Test
    public void testErrorAction() throws Exception {
        shareBoxMonitor.errorAction(new RuntimeException("Test exception"));
        assertTrue("ErrorAction error", !shareBoxMonitor.isPredicate());
    }

    @Test
    public void testAddValuePositive() throws Exception {
        shareBoxMonitor.addValue(12);
        assertEquals("ErrorAction error", shareBoxMonitor.isPredicate(), shareBoxMonitor.getValue() == 12);
    }

    @Test
    public void testAddValueNegative() throws Exception {
        shareBoxMonitor.addValue(-12);
        assertEquals("ErrorAction error", shareBoxMonitor.isPredicate(), shareBoxMonitor.getValue() == 0);
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
