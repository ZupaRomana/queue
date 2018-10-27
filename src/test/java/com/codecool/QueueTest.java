package com.codecool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Trying "Branch" testing method
class QueueTest {

    @Test
    void throwsException_when_nullPassed() {
        CustomQueue queue = new CustomQueue();
        assertThrows(IllegalArgumentException.class, () -> {
            queue.enqueue(null);
        });
    }

    @Test
    void returnsNull_when_PeekInvokedAndNoElemsInQueue() {
        CustomQueue queue = new CustomQueue();

        String expected = null;
        String actual = queue.peek();

        assertEquals(expected, actual);
    }

}