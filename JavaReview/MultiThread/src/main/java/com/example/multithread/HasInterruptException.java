package com.example.multithread;

public class HasInterruptException extends Thread {

    @Override
    public void run() {
        super.run();
        while (!isInterrupted()) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //如果需要在有阻塞代码时也能正常中断线程，需要在阻塞方法检查到中断时再添加中断方法，在此之前可以添加一些善后处理代码
                interrupt();
            }
            System.out.println(Thread.currentThread().getName() + "is running");
            System.out.println(Thread.currentThread().getName() + "now interrupt state " + isInterrupted());
        }
        System.out.println(Thread.currentThread().getName() + "interrupt flag is " + isInterrupted());
    }

    public static void main(String[] args) {
        HasInterruptException hasInterruptException = new HasInterruptException();
        hasInterruptException.start();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hasInterruptException.interrupt();
    }
}