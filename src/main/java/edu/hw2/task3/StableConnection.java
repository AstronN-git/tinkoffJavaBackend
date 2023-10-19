package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) {
        LOGGER.info("Command \"" + command + "\" executed successfully");
    }

    @Override
    public void close() {
        LOGGER.info("Connection closed");
    }
}
