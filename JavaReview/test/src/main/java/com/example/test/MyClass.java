package com.example.test;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {


        int i = 3;
        int targetIndex = 0;

        if (i < 3 || i > 7) {
            System.out.println(-1);
            return;
        }
        if (targetIndex < 0) {
            System.out.println(-1);
            return;
        }

        int indexOfShui = -1;
        int startNum = 0;
        startNum += Math.pow(10, i-1);
        int endNum = 0;
        endNum += Math.pow(10, i) - 1;
        int lastNumShui = -1;
        while (startNum <= endNum) {
            String numString = String.valueOf(startNum);
            String[] numSplits = numString.split("");
            int newNum = 0;
            for (String str : numSplits
            ) {
                newNum += (Math.pow(Integer.decode(str), 3));
            }
            if (newNum == startNum) {
                indexOfShui++;
                lastNumShui = newNum;
                if (indexOfShui == targetIndex) {
                    System.out.println(startNum);
                    return;
                }
            }
            startNum++;
        }
        if (lastNumShui != -1) {
            System.out.println(lastNumShui * targetIndex);
            return;
        }
        System.out.println(-1);
        return;


    }
}