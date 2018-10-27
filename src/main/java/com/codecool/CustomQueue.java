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
        if (isInvalidValue(value)) {
            throw new IllegalArgumentException();
        } else {
            changeFieldsState(value);
        }
    }

    private void changeFieldsState(String value) {
        if (isEmptyQueue()) {
            initializeHead(value);
        } else if (isOneElementInQueue()) {
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

    private boolean isOneElementInQueue() {
        return isEmptyTail();
    }

    private boolean isEmptyTail() {
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

    private boolean isInvalidValue(String value) {
        return value == null;
    }

    public String peek() throws NoSuchElementException {
        if (isEmptyQueue()) {
            throw new NoSuchElementException();
        }
        return getHeadValue();
    }

    private void changeHeadState() {
        if (isOneElementInQueue()){
            setHeadEmpty();
        } else {
            changeHeadReference();
        }
    }

    private void changeHeadReference() {
        head = head.nextNode;
    }

    private void setHeadEmpty() {
        setHeadNull();
    }

    private void setHeadNull() {
        head = null;
    }

    private String getHeadValue() {
        return head.value;
    }

    private boolean isEmptyQueue() {
        return isEmptyHead();
    }

    private boolean isEmptyHead() {
        return head == null;
    }

    public String dequeue() throws NoSuchElementException {
        if (isEmptyQueue()) {
            throw new NoSuchElementException();
        }
        String result = getHeadValue();
        changeHeadState();
        return result;
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
