package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private static final Logger LOGGER = LogManager.getLogger();

    private final ConnectionManager connectionManager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager connectionManager, int maxAttempts) {
        this.connectionManager = connectionManager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    private void tryExecute(String command) {
        ConnectionException exception = null;
        boolean success = false;

        for (int i = 0; i < maxAttempts; i++) {
            try (Connection connection = connectionManager.getConnection()) {
                connection.execute(command);

                success = true;
                break;
            } catch (ConnectionException e) {
                LOGGER.warn("Attempt "  + (i + 1) + " – unsuccessfully");
                exception = e;
            } catch (Exception ignored) {
                // couldn't close connection
            }
        }

        if (!success && exception != null) {
            LOGGER.error("Exceed max attempts");
            throw new RuntimeException("Couldn't execute command", exception);
        }

        LOGGER.info("Command executed successfully");
    }
}
