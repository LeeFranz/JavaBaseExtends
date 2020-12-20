package com.example.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyClass {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        Iterator<String> iterator1 = list1.iterator();
        Iterator<String> iterator2 = list1.iterator();
        while(iterator1.hasNext()) {
            iterator1.next();
            iterator2.remove();
        }

    }


}