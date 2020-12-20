package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解提供有关于程序但不属于程序本身的数据。注解对它们注解的代码的操作没有直接影响。

//以下两种注解成为元注解，即对注解类型进行注解的注解类
@Target(ElementType.TYPE)//定义注解的适用范围，可以定义多个范围，中间用逗号分割
@Retention(RetentionPolicy.SOURCE)
//定义注解的有效时间区间
//1、RetentionPolicy.SOURCE  标记的注解仅保留在源级别中，并被编译器忽略
//作用于源码级别的注解，可提供给IDE语法检查、APT等场景使用。APT全称为："Anotation Processor Tools"，意为注解处理器。注解处理器是 javac 自带的一个工
//具，用来在编译时期扫描处理注解信息。
//2、RetentionPolicy.CLASS  标记的注解在编译时由编译器保留，但 Java 虚拟机(JVM)会忽略
//常用于字节码操作，即直接修改字节码Class文件以达到修改代码执行逻辑的目的。
//3、RetentionPolicy.RUNTIME  标记的注解由 JVM 保留，因此运行时环境可以使用它
//注解保留至运行期，意味着我们能够在运行期间结合反射技术获取注解中的所有信息。
public @interface Heria {
    String name() default "heria";
    int age() default 26;
}

//自定义注解使用见app模块但AnnotationTest.java
