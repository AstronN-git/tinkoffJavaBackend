package edu.hw1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    void testMinutesToSeconds() {
        assertEquals(30, Task1.minutesToSeconds("00:30"));
        assertEquals(326, Task1.minutesToSeconds("05:26"));
        assertEquals(60, Task1.minutesToSeconds("01:00"));
        assertEquals(836, Task1.minutesToSeconds("13:56"));
        assertEquals(-1, Task1.minutesToSeconds("10:60"));
        assertEquals(-1, Task1.minutesToSeconds("3:10:20"));
        assertEquals(-1, Task1.minutesToSeconds("Invalid String"));
    }
}
