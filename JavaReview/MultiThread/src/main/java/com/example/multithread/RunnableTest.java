package com.example.multithread;


public class RunnableTest implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (this) {
                try {
                    System.out.println(Thread.currentThread().getName() + "sleep start");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "sleep end");
            }
            System.out.println(Thread.currentThread().getName() + " continue...");
        }
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread1 = new Thread(runnableTest);
        Thread thread2 = new Thread(runnableTest);
        thread1.start();
        thread2.start();
    }
}
