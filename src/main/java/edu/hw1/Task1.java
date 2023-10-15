package edu.hw1;

public class Task1 {
    public static int minutesToSeconds(String length) {
        String[] parts = length.split(":");

        if (parts.length > 2)
            return -1;

        int minutes, seconds;

        try {
            minutes = Integer.parseInt(parts[0]);
            seconds = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            return -1;
        }

        if (seconds >= 60 || seconds < 0 || minutes < 0) return -1;
        return minutes * 60 + seconds;
    }
}
