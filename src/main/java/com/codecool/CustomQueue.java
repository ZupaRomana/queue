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
        Node tempTail = createNewNode(value);
        setTailReference(tempTail);
        changeTail(tempTail);
    }

    private void changeTail(Node tailToSet) {
        tail = tailToSet;
    }

    private void setTailReference(Node tailToReference) {
        tail.nextNode = tailToReference;
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
        tail = createNewNode(value);
    }

    private void initializeHead(String value) {
        head = createNewNode(value);
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
