package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private static final int END_NUMBER = 6174;

    @SuppressWarnings("MagicNumber")
    public int countK(int number) {
        if (number == END_NUMBER) {
            return 0;
        }

        int num = number;

        int[] digits = new int[4];

        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }

        Arrays.sort(digits);

        int numberDesc = 0;
        int numberAsc = 0;

        for (int i = 0; i < 4; i++) {
            numberAsc *= 10;
            numberAsc += digits[i];
        }

        for (int i = 3; i >= 0; i--) {
            numberDesc *= 10;
            numberDesc += digits[i];
        }

        return countK(numberDesc - numberAsc) + 1;
    }
}
