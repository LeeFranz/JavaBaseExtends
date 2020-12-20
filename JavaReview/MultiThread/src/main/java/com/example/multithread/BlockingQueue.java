package com.example.multithread;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

    private List queue = new LinkedList();
    private int limit;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        if (queue.size() >= limit) {
            wait();
        }
        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(item);
    }

    public synchronized void dequeue() throws InterruptedException {
        if (queue.size() <= 0) {
            wait();
        }
        if (queue.size() >= limit) {
            notifyAll();
        }
        queue.remove(0);
    }


}
