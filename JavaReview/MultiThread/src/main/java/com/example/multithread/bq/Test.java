package com.example.multithread.bq;

import java.util.concurrent.DelayQueue;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<ItemVo<Order>> queue = new DelayQueue<ItemVo<Order>>();//延时队列

        Thread offerThread = new Thread(new Fetchorder(queue));
        Thread fetchThread = new Thread(new OfferOrder(queue));

        offerThread.start();
        fetchThread.start();

        long delayTime = 0L;
        while (true) {
            Thread.sleep(500);
            System.out.println("delayedTime: " + delayTime);
            delayTime += 500L;
        }
    }
}
