package com.example.javareview;

import org.w3c.dom.ls.LSOutput;

public class ObjTest {

    public static void main(String[] args) {
        PDD pp = new PDD();
        PDD ppp = pp;
        System.out.println(pp);
        System.out.println(ppp);
        pp = null;
        System.out.println(pp);
        System.out.println(ppp);
    }
}

class PDD {
}
