package com.example.multithread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    private static Lock No13 = new ReentrantLock();//第一个锁
    private static Lock No14 = new ReentrantLock();//第二个锁
    private static final Random r = new Random();

    public static void HeriaDo() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        while (true) {
            if (No13.tryLock()) {
                try {
                    if (No14.tryLock()) {
                        try {
                            System.out.println(threadName + "do sth");
                            break;
                        } finally {
                            No14.unlock();
                        }
                    }
                } finally {
                    No13.unlock();
                }
            }
            //Thread.sleep(r.nextInt(3));
        }
    }

    public static void LeoDo() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        while (true) {
            if (No14.tryLock()) {
                try {
                    if (No13.tryLock()) {
                        try {
                            System.out.println(threadName + "do sth");
                            break;
                        } finally {
                            No13.unlock();
                        }
                    }
                } finally {
                    No14.unlock();
                }
            }
            //Thread.sleep(r.nextInt(3));
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    HeriaDo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        LeoDo();
    }


}
