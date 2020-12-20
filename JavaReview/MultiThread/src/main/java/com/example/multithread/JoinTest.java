package com.example.multithread;

public class JoinTest {
    static class A extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " runing end");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A aa = new A();
        a.start();
        aa.start();
        try {
            aa.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
