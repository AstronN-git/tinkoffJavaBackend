package edu.hw1;

public final class Task1 {
    private Task1() {}

    private final static int MAX_SECONDS = 60;

    public static int minutesToSeconds(String length) {
        String[] parts = length.split(":");

        if (parts.length > 2) {
            return -1;
        }

        int minutes;
        int seconds;

        try {
            minutes = Integer.parseInt(parts[0]);
            seconds = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            return -1;
        }

        if (seconds >= MAX_SECONDS || seconds < 0 || minutes < 0) {
            return -1;
        }

        return minutes * MAX_SECONDS + seconds;
    }
}
