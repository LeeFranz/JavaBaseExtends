package com.example.test;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;

public class Main {

    public static int function(int n) {
        try {
            n = n / 0;
            return n;
        } catch (Exception e) {
            n = 100;
            return n;
        } finally {
            System.out.println("finally execution");
            //return 200;
        }
    }

    public static void function2() {
        System.out.println("do sth in function2");
    }

    public static String readData(BufferedReader in) throws FileFormatException {
        //do sth
        throw new FileFormatException();

    }

    public static void main(String[] args) {
        System.out.println(Main.function(2));

    }
}

class FileFormatException extends IOException {
    public FileFormatException() {
    }

    public FileFormatException(String s) {
        super(s);
    }
}
