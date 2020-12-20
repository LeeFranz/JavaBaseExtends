package com.example.javareview.inject;

import android.app.Activity;
import android.view.View;

import com.example.javareview.InjectActivity;

import java.lang.reflect.Field;

public class InjectUtil {
    public static void injectView(Activity activity) {
        Class<? extends Activity> cls = activity.getClass();

        //获得此类所有的成员
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field filed : declaredFields) {
            // 判断属性是否被InjectView注解声明
            if (filed.isAnnotationPresent(InjectRes.class)) {
                InjectRes injectRes = filed.getAnnotation(InjectRes.class);
                //获得了注解中设置的id
                int id = injectRes.value();
                View view = activity.findViewById(id);
                //反射设置 属性的值
                filed.setAccessible(true); //设置访问权限，允许操作private的属性
                try {
                    //反射赋值
                    filed.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
