package edu.hw1;

public class Task7 {
    private int findLargestSetBit(int number) {
        int result = -1;
        for (int i = 0; i < 32; i++) {
            if ((number & (1 << i)) != 0) {
                result = i;
            }
        }

        return result;
    }

    public int rotateLeft(int number, int shift) {
        if (number == 0) {
            return 0;
        }

        int largestBit = findLargestSetBit(number);
        shift %= (largestBit + 1);

        int shiftMask = 0;
        for (int i = largestBit; i > largestBit - shift; i--) {
            shiftMask |= (1 << i);
        }

        int bigMask = 0;
        for (int i = 0; i <= largestBit; i++) {
            bigMask |= (1 << i);
        }

        return ((number << shift) & bigMask) | ((number & shiftMask) >> (largestBit - shift + 1));
    }

    public int rotateRight(int number, int shift) {
        if (number == 0) {
            return 0;
        }

        int largestBit = findLargestSetBit(number);
        shift %= (largestBit + 1);

        int mask = 0;
        for (int i = 0; i < shift; i++) {
            mask |= (1 << i);
        }

        return (number >> shift) | ((number & mask) << (largestBit - shift + 1));
    }
}
