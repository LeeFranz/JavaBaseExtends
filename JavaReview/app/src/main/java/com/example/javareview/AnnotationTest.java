package com.example.javareview;

import androidx.annotation.DrawableRes;
import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

class AnnotationTest {
    public static void setDrawable(@DrawableRes int id) {

    }

    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;

    //注解限定，只能在参数中传入限定的值，否则IDE会提示报错，但不影响编译
    //这样可以一定程度上替换枚举，因为即保留了枚举但好处，又省掉了枚举带来但内存开销，因为枚举本质上是一组实例
    @IntDef({SUNDAY, MONDAY})
    @Retention(RetentionPolicy.SOURCE)
    @Target(PARAMETER)
    @interface WEEKDAYRefs {
    }

    public static void setDate(@WEEKDAYRefs int date) {

    }

    public static void main(String[] args) {
        AnnotationTest.setDate(3);
        AnnotationTest.setDate(SUNDAY);
    }

}
