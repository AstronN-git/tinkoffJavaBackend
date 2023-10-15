package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    void testRotateRight() {
        Task7 task = new Task7();

        // 1011 >> 1 -> 1101
        assertEquals(0b1101, task.rotateRight(0b1011, 1));

        // 1000 >> 1 -> 0100
        assertEquals(0b0100, task.rotateRight(0b1000, 1));

        // 101101 >> 2 -> 011011
        assertEquals(0b011011, task.rotateRight(0b101101, 2));

        // 10 >> 10 -> 10
        assertEquals(0b10, task.rotateRight(0b10, 10));
    }

    @Test
    void testRotateLeft() {
        Task7 task = new Task7();

        // 10000 << 1 -> 00001
        assertEquals(0b00001, task.rotateLeft(0b10000, 1));

        // 10001 << 2 -> 00110
        assertEquals(0b00110, task.rotateLeft(0b10001, 2));

        // 101110 << 3 -> 110101
        assertEquals(0b110101, task.rotateLeft(0b101110, 3));

        // 10 << 11 -> 01
        assertEquals(0b01, task.rotateLeft(0b10, 11));
    }
}
