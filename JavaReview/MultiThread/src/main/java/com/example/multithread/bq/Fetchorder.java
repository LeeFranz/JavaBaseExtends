package com.example.multithread.bq;

import java.util.concurrent.DelayQueue;

public class Fetchorder implements Runnable {

    private DelayQueue<ItemVo<Order>> delayQueue;

    public Fetchorder(DelayQueue<ItemVo<Order>> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ItemVo<Order> orderItemVo = delayQueue.take();
                Order order = orderItemVo.getData();
                System.out.println("Get From Queue:"+"data="
                        +order.getOrderNo()+";"+order.getOrderMoney());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
