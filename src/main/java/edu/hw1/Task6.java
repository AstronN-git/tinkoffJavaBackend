package edu.hw1;

import java.util.Arrays;

public class Task6 {
    public int countK(int number) {
        if (number == 6174) {
            return 0;
        }

        int[] digits = new int[4];

        for (int i = 0; i < 4; i++) {
            digits[i] = number % 10;
            number /= 10;
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
