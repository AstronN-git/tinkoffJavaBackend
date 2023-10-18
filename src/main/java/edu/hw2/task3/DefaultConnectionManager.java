package edu.hw2.task3;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DefaultConnectionManager implements ConnectionManager {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final double FAULTY_CONNECTION_PROBABILITY = 0.2;

    @Override
    public Connection getConnection() {
        Random random = new Random();

        if (random.nextDouble() < FAULTY_CONNECTION_PROBABILITY) {
            LOGGER.info("Got faulty connection");
            return new FaultyConnection();
        } else {
            LOGGER.info("Got stable connection");
            return new StableConnection();
        }
    }
}
