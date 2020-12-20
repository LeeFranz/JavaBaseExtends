package com.example.multithread;

import java.util.Queue;

public class Consumer<T> {

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    private Queue<T> tasks;

    public T consume() throws InterruptedException {
        synchronized (tasks) {
            while (tasks.size() <= 0) {
                System.out.println("线程进入等待状态。。。" + Thread.currentThread().getName());
                tasks.wait();
            }
            T task = tasks.poll();
            tasks.notifyAll();

            return task;
        }
    }
}