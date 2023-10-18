package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    void testRotateRight() {
        Task7 task = new Task7();

        // 1011 >> 1 -> 1101
        assertEquals(13, task.rotateRight(11, 1));

        // 1000 >> 1 -> 0100
        assertEquals(4, task.rotateRight(8, 1));

        // 101101 >> 2 -> 011011
        assertEquals(27, task.rotateRight(45, 2));

        // 10 >> 10 -> 10
        assertEquals(2, task.rotateRight(2, 10));
    }

    @Test
    void testRotateLeft() {
        Task7 task = new Task7();

        // 10000 << 1 -> 00001
        assertEquals(1, task.rotateLeft(16, 1));

        // 10001 << 2 -> 00110
        assertEquals(6, task.rotateLeft(17, 2));

        // 101110 << 3 -> 110101
        assertEquals(53, task.rotateLeft(46, 3));

        // 10 << 11 -> 01
        assertEquals(1, task.rotateLeft(2, 11));
    }
}
