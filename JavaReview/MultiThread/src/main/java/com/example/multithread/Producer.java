package com.example.multithread;

import java.util.Queue;

public class Producer<T> {

    private Queue<T> tasks;
    private int limit;

    public Producer(Queue<T> tasks, int limit) {
        this.tasks = tasks;
        this.limit = limit;
    }

    public void produce(T task) throws InterruptedException {
        synchronized (tasks) {
            while(tasks.size() >= limit) {
                System.out.println("线程进入等待状态。。。" + Thread.currentThread().getName());
                tasks.wait();
            }
            tasks.add(task);
            tasks.notifyAll();
        }
    }
}