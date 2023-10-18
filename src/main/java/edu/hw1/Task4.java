package edu.hw1;

public final class Task4 {
    private Task4() {}

    public static String fixString(String input) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i + 1 < input.length(); i += 2) {
            resultBuilder.append(input.charAt(i + 1));
            resultBuilder.append(input.charAt(i));
        }

        if (input.length() % 2 == 1) {
            resultBuilder.append(input.charAt(input.length() - 1));
        }

        return resultBuilder.toString();
    }
}
