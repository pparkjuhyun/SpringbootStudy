package com.example.demo.event;

public class LatestStyleEvent {
    private int data;
    private Object source;

    public LatestStyleEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }

    public Object getSource() {
        return source;
    }

    public int getData() {
        return data;
    }
}
