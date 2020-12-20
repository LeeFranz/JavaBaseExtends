package com.example.multithread.castest;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MultitaskTest {

    private AtomicInteger count = new AtomicInteger(0);
    public int age = 3;
    String outStr = "hl";

    class PDD {
        String weight;

        void hahaha() {
            System.out.println(MultitaskTest.this.outStr);
            System.out.println("hahaha");
        }
    }

    void funtion3(int age) {
        System.out.println(age);
        function4(age);
        System.out.println(age);
    }

    void function4(int oldAge) {
        oldAge++;
        System.out.println("age in function4 is " + oldAge);

    }

    void function() {
        new PDD() {
            @Override
            void hahaha() {
                System.out.println(MultitaskTest.this.age);
            }
        }.hahaha();
    }


    public static void main(String[] args) {
        ArrayList<? extends Throwable> arrayList = new ArrayList<>();
        ArrayList<RuntimeException> arrayList1 = new ArrayList<>();

    }
}
