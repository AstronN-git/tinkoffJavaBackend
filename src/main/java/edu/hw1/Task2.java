package edu.hw1;

public class Task2 {
    public static int countDigits(int number) {
        int digits = 0;
        do {
            digits++;
            number /= 10;
        } while (number != 0);

        return digits;
    }
}
