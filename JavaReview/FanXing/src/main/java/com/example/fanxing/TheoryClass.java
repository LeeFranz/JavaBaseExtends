package com.example.fanxing;


import java.util.ArrayList;

//JDK实现泛型的原理是类型擦除
//下面的例子中会把T统一修改成Object
public class TheoryClass<T> {
    private T mData;

    public T getmData() {
        return mData;
    }

    public void setmData(T mData) {
        this.mData = mData;
    }

    public static void main(String[] args) {
        TheoryClass<String> theoryClass = new TheoryClass<>();
        TheoryClass<Double> theoryClass1 = new TheoryClass<>();

    }
}

//这种情况下泛型会被统一擦除成Arraylist,如果都是接口会被统一擦除成实现的第一个接口
//如果在泛型的第某个方法中用到了Comparable接口，那么泛型参数前会被添加一个强制转型声明
class TheoryClass2<T extends ArrayList&Comparable> {

        }


