package com.example.fanxing;

public class GenericImp<T> implements Generic<T> {
    @Override
    public T getData() {
        return null;
    }

}

class GenericImp2 implements Generic<String> {

    @Override
    public String getData() {
        return null;
    }
}

class Test {
    public static void main(String[] args) {
        GenericImp<String> genericImp = new GenericImp();
        genericImp.getData();
    }
}
