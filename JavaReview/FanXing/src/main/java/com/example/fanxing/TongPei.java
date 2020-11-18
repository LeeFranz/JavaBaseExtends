package com.example.fanxing;

public class TongPei<T> {

    public void function(T t) {
     //do sth with T
    }

    public static void function2(TongPei<Fruit> k){

    }

    public static void function3(TongPei<? extends Fruit> kk) {

    }

    public static void function4(TongPei<? super Fruit> kkk) {

    }

    public static void main(String[] args) {
        TongPei<Fruit> tongPei = new TongPei<>();
        TongPei<Orange> orangeTongPei = new TongPei<>();
        tongPei = orangeTongPei; // 泛型类的类型参数之间的继承关系不决定泛型类之间的继承关系，TongPei<Fruit>和TongPei<Orange>无关
        function2(tongPei);//ok
        function2(orangeTongPei);//进一步印证类上一点，但是实际需求中我们需要TongPei<Orange>也满足需求

        //添加通配符之后就能让函数接受的泛型类参数类型扩宽
        //extends
        function3(tongPei);
        function3(orangeTongPei);
        //super
        function4(tongPei);
        function4(orangeTongPei);
    }
}

class Fruit {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Orange extends Fruit{
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
