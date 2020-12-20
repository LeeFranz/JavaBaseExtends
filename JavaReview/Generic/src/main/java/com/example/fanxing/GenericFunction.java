package com.example.fanxing;

public class GenericFunction {

    private <T> void showData(T t) {
        System.out.println(t.toString());
    }

    private <K> K getOtherData(K... ks) {//真正意义上的泛型方法
        return (ks[ks.length / 3]);
    }

    private <T, K> K getOtherData2(T... ts) {
        return null;
    }

    public static void main(String[] args) {
        GenericFunction genericFunction = new GenericFunction();
        System.out.println(genericFunction.<String>getOtherData("2", "3", "4"));
        System.out.println(genericFunction.getOtherData(new TheoryClass<>(), new TheoryClass<>(), new TheoryClass<>()));
    }
}
