package com.example.fanxing;

public class Restrict<T> {
    private T mData;

    public Restrict() {
        //T t = new T(); // 不可用
    }

    /*public static T function() { // 不可用，泛型类型在实例化对象时候才确定，静态方法类型确定在实例化之前
        return null;
    }*/

    public static <E> void function2() {//ok

    }

    //泛型类类型的确定
    public static void main(String[] args) {
        Restrict<String> restrict1 = new Restrict<>();
        Restrict<Double> restrict2 = new Restrict<>();
        System.out.println(restrict1.getClass() == restrict2.getClass());
        System.out.println(restrict1.getClass());
        System.out.println(restrict2.getClass());
        /*true
        class com.example.fanxing.Restrict
        class com.example.fanxing.Restrict*/
        //泛型类型获取类型时候获取的是原生类型
        //System.out.println(restrict1 instanceof Restrict<String>); // 不可用

    }

}

/*
class Restrict2 {
    //泛型不能被捕获，但是能主动抛出
    private <T extends  Throwable> void function (T t) {
        try{

        }catch (T t){

        }
    }

    private <T extends  Throwable> void function2 (T t) throws T {
        try{

        }catch (Throwable e){
            throw t;
        }
    }
}
*/
