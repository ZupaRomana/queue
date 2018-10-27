package com.codecool;

import java.util.NoSuchElementException;

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
            changeFieldsState(value);
        }
    }

    private void changeFieldsState(String value) {
        if (emptyQueue()) {
            initializeHead(value);
        } else if (emptyTail()) {
            initializeTail(value);
            setHeadNextNodeToTail();
        } else {
            changeTailState(value);
        }
    }

    private void changeTailState(String value) {
        Node newTail = createNewNode(value);
        setTailReference(newTail);
        changeTail(newTail);
    }

    private void changeTail(Node newTail) {
        tail = newTail;
    }

    private void setTailReference(Node newTail) {
        tail.nextNode = newTail;
    }

    private Node createNewNode(String value) {
        return new Node(value, null);
    }

    private boolean emptyTail() {
        return tail == null;
    }

    private void setHeadNextNodeToTail() {
        head.nextNode = tail;
    }

    private void initializeTail(String value) {
        tail = new Node(value, null);
    }

    private void initializeHead(String value) {
        head = new Node(value, tail);
    }

    private boolean invalidValue(String value) {
        return value == null;
    }

    public String peek() throws NoSuchElementException {
        if (emptyQueue()) {
            throw new NoSuchElementException();
        }
        return getHeadValue();
    }

    private String getHeadValue() {
        return head.value;
    }

    private boolean emptyQueue() {
        return emptyHead();
    }

    private boolean emptyHead() {
        return head == null;
    }

    public String dequeue() throws NoSuchElementException {
        if (emptyQueue()) {
            throw new NoSuchElementException();
        }
        return getHeadValue();
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
