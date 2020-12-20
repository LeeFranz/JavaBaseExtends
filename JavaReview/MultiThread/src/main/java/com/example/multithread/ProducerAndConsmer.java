package com.example.multithread;

public class ProducerAndConsmer {

    boolean mFlag = false;

    public static void main(String[] args) {
        ProducerAndConsmer producerAndConsmer = new ProducerAndConsmer();
        Getter getter = new Getter(producerAndConsmer);
        Setter setter = new Setter(producerAndConsmer);
        Thread thread1 = new Thread(getter);
        Thread thread2 = new Thread(setter);
        thread1.start();
        thread2.start();
    }
}

class Getter implements Runnable {

    private ProducerAndConsmer lock;

    public Getter(ProducerAndConsmer lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (lock.mFlag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + "do getter...");
                lock.mFlag = true;
                lock.notify();
            }
        }

    }
}

class Setter implements Runnable {

    private ProducerAndConsmer lock;

    public Setter(ProducerAndConsmer lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (!lock.mFlag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + "do setter...");
                lock.mFlag = false;
                lock.notify();
            }
        }

    }
}