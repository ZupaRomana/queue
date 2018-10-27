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

    @Test
    void returnsValidValue_when_oneItemPassed() {
        CustomQueue queue = new CustomQueue();
        queue.enqueue("example");

        String expected = "example";
        String actual = queue.peek();

        assertEquals(expected, actual);
    }

    @Test
    void returnsValidValue_when_manyItemsPassed() {
        CustomQueue queue = new CustomQueue();
        fillQueue(5);

        String expected = "1";
        String actual = queue.peek();

        assertEquals(expected, actual);
    }

}