package edu.hw1;

public class Task7 {
    private static final int MAX_INTEGER_BIT = 32;

    private int findLargestSetBit(int number) {
        int result = -1;
        for (int i = 0; i < MAX_INTEGER_BIT; i++) {
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
        int localShift = shift % (largestBit + 1);

        int shiftMask = 0;
        for (int i = largestBit; i > largestBit - localShift; i--) {
            shiftMask |= (1 << i);
        }

        int bigMask = 0;
        for (int i = 0; i <= largestBit; i++) {
            bigMask |= (1 << i);
        }

        return ((number << localShift) & bigMask) | ((number & shiftMask) >> (largestBit - localShift + 1));
    }

    public int rotateRight(int number, int shift) {
        if (number == 0) {
            return 0;
        }

        int largestBit = findLargestSetBit(number);
        int localShift = shift % (largestBit + 1);

        int mask = 0;
        for (int i = 0; i < localShift; i++) {
            mask |= (1 << i);
        }

        return (number >> localShift) | ((number & mask) << (largestBit - localShift + 1));
    }
}
