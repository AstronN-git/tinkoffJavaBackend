package edu.hw2;

import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FaultyConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {
    private static final Logger LOGGER = LogManager.getLogger();

    @RepeatedTest(10)
    void testFaultyConnectionManager() {
        FaultyConnectionManager manager = new FaultyConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 10);

        RuntimeException exception = null;
        int attempts = 0;

        while (exception == null) {
            try {
                attempts++;
                executor.updatePackages();
            } catch (RuntimeException e) {
                exception = e;
            }
        }

        assertInstanceOf(ConnectionException.class, exception.getCause());

        // As maxAttempts quite high, and chance of runtime is about 0.7,
        // it takes approx. 30 attempts to get here (based on my tests)
        LOGGER.info("Spent " + attempts + " attempts to get exception");
    }

    @RepeatedTest(10)
    void testDefaultConnectionManager() {
        DefaultConnectionManager manager = new DefaultConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 1);

        RuntimeException exception;
        int attempts = 0;
        do {
            exception = null;

            try {
                attempts++;
                executor.updatePackages();
            } catch (RuntimeException e) {
                exception = e;
                assertInstanceOf(ConnectionException.class, e.getCause());
            }
        } while (exception != null);

        // Usually 1, but sometimes 2+ (chance of 2 is .7 * .2 = .14)
        LOGGER.info("Spent " + attempts + " attempts to execute successfully");
    }
}
