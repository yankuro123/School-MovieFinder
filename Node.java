package com.company;

public class Node {

    protected String contents;
    protected Node next;
    public Node() {
        this(null, null);
    }
    public Node(String contents) {
        this (contents, null);
    }

    public Node(String contents, Node next) {
        this.contents = contents;
        this.next     = next;
    }
    protected String getContents() {
        return contents;
    }


    protected void setContents(String contents) {
        this.contents = contents;
    }

    protected Node getNext() {
        return next;
    }
    protected void setNext(Node next) {
        this.next = next;
    }
}