package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    void testIsPalindromeDescendant() {
        Task5 task = new Task5();

        assertTrue(task.isPalindromeDescendant(11211230));
        assertTrue(task.isPalindromeDescendant(13001120));
        assertTrue(task.isPalindromeDescendant(23336014));
        assertTrue(task.isPalindromeDescendant(11));
        assertFalse(task.isPalindromeDescendant(1234));
        assertFalse(task.isPalindromeDescendant(9));
        assertFalse(task.isPalindromeDescendant(113));
    }
}
