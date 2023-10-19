package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnectionManager implements ConnectionManager {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Connection getConnection() {
        LOGGER.info("Got faulty connection");
        return new FaultyConnection();
    }
}
