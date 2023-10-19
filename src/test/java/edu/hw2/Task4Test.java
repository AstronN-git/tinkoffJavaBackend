package edu.hw2;

import edu.hw2.task4.CallingInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void testCallingInfo() {
        var info = CallingInfo.callingInfo();

        LOGGER.info("Method: " + info.methodName());
        LOGGER.info("Class: " + info.className());

        assertEquals("testCallingInfo", info.methodName());
        assertEquals("edu.hw2.Task4Test", info.className());
    }
}
