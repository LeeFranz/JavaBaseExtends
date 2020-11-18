package com.example.fanxing;


public class NormalGeneric<T>{
    private T data;

    public NormalGeneric(T data) {
        this.data = data;
    }

    public T getData() {//注意这是普通方法，只是返回泛型类型对象
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        NormalGeneric<String> normalGeneric = new NormalGeneric<>("Heria");
        System.out.println(normalGeneric.getData());
    }
}

