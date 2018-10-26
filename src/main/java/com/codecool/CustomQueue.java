package com.codecool;

public class CustomQueue {

    private Node head;
    private Node tail;

    public CustomQueue() {
        head = null;
        tail = null;
    }

    public void enqueue(String value) throws IllegalArgumentException {
        if (isProperValue(value)) {
            throw new IllegalArgumentException();
        } else {

        }
    }

    private boolean isProperValue(String value) {
        return value == null;
    }

    public String peek() {
        return null;
    }

    public String dequeue() {
        return null;
    }

    private class Node {
        private String value;
        private Node nextNode;

        Node(String value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }
}
