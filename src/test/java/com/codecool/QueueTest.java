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

}