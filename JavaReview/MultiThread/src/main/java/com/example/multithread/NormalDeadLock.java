package com.example.multithread;

public class NormalDeadLock {

    public static final Object obj1 = new Object();
    public static final Object obj2 = new Object();

    public static void HeriaDo() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (obj1) {
            System.out.println(threadName + "get obj1");
            Thread.sleep(200);
            synchronized (obj2) {
                System.out.println(threadName + "get obj2");
            }
        }
    }

    public static void LeoDo() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (obj2) {
            System.out.println(threadName + "get obj2");
            Thread.sleep(200);
            synchronized (obj1) {
                System.out.println(threadName + "get obj1");
            }
        }
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    NormalDeadLock.HeriaDo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    NormalDeadLock.LeoDo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
