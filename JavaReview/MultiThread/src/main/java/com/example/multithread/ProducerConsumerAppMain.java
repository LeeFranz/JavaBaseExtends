package com.example.multithread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerAppMain {

    public static void main(String[] args) {
        Queue<String> tasks = new LinkedList<>();
        Producer<String> producer = new Producer<>(tasks, 1024);
        Consumer<String> consumer = new Consumer<>(tasks);
        for (int i = 0; i < 3; i++) {
            Thread produceThread = new Thread(() -> {
                while (true) {
                    try {
                        producer.produce(produceURL());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"producer" + i);

            produceThread.start();
        }


        for (int i = 0; i < 20; i++) {
            Thread consumerThread = new Thread(() -> {
                while (true) {
                    try {
                        String task = consumer.consume();
                        processURL(task);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }, "consumer" + i);
            consumerThread.start();
        }

    }

    private static String produceURL() {
        StringBuilder ret = new StringBuilder();
        ret.append("www.");
        for (int i = 0; i < 6; i++) {
            int rand = ((int) (Math.random() * 1000)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
        }
        ret.append(".com");
        return ret.toString();
    }

    private static void processURL(String url) throws InterruptedException {
        System.out.println("开始处理：" + url);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("处理完成：" + url);
    }

}