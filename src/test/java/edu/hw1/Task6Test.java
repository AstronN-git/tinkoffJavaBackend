package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    void testCountK() {
        Task6 task = new Task6();

        assertEquals(3, task.countK(3524));
        assertEquals(5, task.countK(6621));
        assertEquals(4, task.countK(6554));
        assertEquals(3, task.countK(1234));

        assertEquals(0, task.countK(6174));
        assertEquals(4, task.countK(1001));
        assertEquals(5, task.countK(9998));
    }
}
