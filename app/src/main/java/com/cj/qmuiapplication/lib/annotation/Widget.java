package com.cj.qmuiapplication.lib.annotation;

import com.cj.qmuiapplication.lib.Group;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Widget {
    Group group() default Group.Component;

    int iconRes() default 0;

    String name() default "";

    Class widgetClass() default void.class;
}
