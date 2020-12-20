package com.example.javareview;

public class SingleInstanceTest {

    private volatile SingleInstanceTest singleInstanceTest;

    private SingleInstanceTest() {
    }

    public SingleInstanceTest getInstance() {
        if (singleInstanceTest == null) {
            synchronized (SingleInstanceTest.class) {
                if (singleInstanceTest == null) {
                    singleInstanceTest = new SingleInstanceTest();
                }
            }
        }
        return singleInstanceTest;
    }

}
