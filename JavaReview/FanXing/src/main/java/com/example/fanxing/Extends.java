package com.example.fanxing;

import java.util.ArrayList;


// 限定泛型的继承类型 规则同Java继承规范，即只能继承一个类同时可以继承多个接口
public class Extends<T extends ArrayList&Comparable&Runnable> {
}

class Exrtends2 {
    private <E extends ArrayList&Comparable&Runnable> void extrendsFun() {

    }
}
