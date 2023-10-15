package edu.hw1;

public class Task5 {
    private boolean isNumberPalindrome(int number) {
        String numberAsString = String.valueOf(number);
        for (int i = 0; i < numberAsString.length() / 2; i++) {
            if (numberAsString.charAt(i) != numberAsString.charAt(numberAsString.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    private int getNextNumber(int number) {
        StringBuilder nextNumberBuilder = new StringBuilder();

        String numberAsString = String.valueOf(number);
        for (int i = 0; i + 1 < numberAsString.length(); i += 2) {
            char first = numberAsString.charAt(i);
            char second = numberAsString.charAt(i+1);

            int sum = first - '0' + second - '0';
            nextNumberBuilder.append(sum);
        }

        if (numberAsString.length() % 2 == 1) {
            nextNumberBuilder.append(numberAsString.charAt(numberAsString.length() - 1));
        }

        return Integer.parseInt(nextNumberBuilder.toString());
    }

    public boolean isPalindromeDescendant(int number) {
        while (number >= 10) {
            if (isNumberPalindrome(number)) {
                return true;
            }

            number = getNextNumber(number);
        }

        return false;
    }
}
