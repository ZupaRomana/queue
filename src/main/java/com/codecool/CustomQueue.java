package com.codecool;

public class CustomQueue {

    private Node head;
    private Node tail;

    public CustomQueue() {
        head = null;
        tail = null;
    }

    public void enqueue(String value) throws IllegalArgumentException {
        if (invalidValue(value)) {
            throw new IllegalArgumentException();
        } else {

        }
    }

    private boolean invalidValue(String value) {
        return value == null;
    }

    public String peek() {
        return emptyQueue() ? null : getHeadValue();
    }

    private String getHeadValue() {
        return head.value;
    }

    private boolean emptyQueue() {
        return head == null;
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
