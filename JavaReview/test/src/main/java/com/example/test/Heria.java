package com.example.test;


import java.io.IOException;

class People {
    String name = "people";
    private String date = "xx";

    public String getDate() throws IOException {
        return date;
    }

    private void functionA() {
        System.out.println("people");
    }

    public String getName() {
        return name;
    }
}

class Heria extends People {
    String name = "Heria";
    private String date = "oo";

    @Override
    public String getDate() throws IOException {
        return date;
    }

    private void functionA() {
        System.out.println("Heria");
    }

    public void showName() {
        System.out.println(name);
        System.out.println(super.name);
    }
}


class test {
    public static void main(String[] args) {
        People people1 = new People();
        People people2 = new Heria();
    }

}

//简而言之  Java中，只有非私有的方法能被覆盖，私有方法和属性不能被覆盖，属性不存在继承，即便子类和父类中存在相同名字和类型的属性，也会在子类和父类中分别保存一份

//动态绑定中，如果父类引用指向了子类，其只能调用父类的方法，但使用的是子类的具体实现，如果使用其属性，则指向父类的属性，如果该引用是子类引用，则使用属性指向子类属性。












