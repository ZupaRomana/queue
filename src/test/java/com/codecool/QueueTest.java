package com.codecool;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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
        fillQueue(queue, 5);

        String expected = "1";
        String actual = queue.peek();

        assertEquals(expected, actual);
    }

    @Test
    void throwsException_when_peekInvokedAndNoElems() {
        CustomQueue queue = new CustomQueue();

        assertThrows(NoSuchElementException.class, () -> {
            String result = queue.peek();
        });
    }

    @Test
    void throwsException_when_deQueueInvokedAndNoElems() {
        CustomQueue queue = new CustomQueue();

        assertThrows(NoSuchElementException.class, () -> {
            String result = queue.dequeue();
        });
    }

    @Test
    void returnsValidValue_when_deQueueInvokedOneElemPassed() {
        CustomQueue queue = new CustomQueue();
        queue.enqueue("example");

        String expected = "example";
        String actual = queue.dequeue();

        assertEquals(expected, actual);
    }

    private void fillQueue(CustomQueue queue, int numOfElems) {
        for (int i = 1; i <= numOfElems; i++) {
            queue.enqueue(Integer.toString(i));
        }
    }

}