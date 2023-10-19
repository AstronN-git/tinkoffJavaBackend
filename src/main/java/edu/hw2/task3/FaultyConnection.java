package edu.hw2.task3;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final double EXCEPTION_PROBABILITY = 0.7;

    @Override
    public void execute(String command) throws ConnectionException {
        Random random = new Random();
        if (random.nextDouble() < EXCEPTION_PROBABILITY) {
            LOGGER.warn("Couldn't execute command");
            throw new ConnectionException();
        } else {
            LOGGER.info("Command \"" + command + "\" executed successfully");
        }
    }

    @Override
    public void close() {
        LOGGER.info("Connection closed");
    }
}
