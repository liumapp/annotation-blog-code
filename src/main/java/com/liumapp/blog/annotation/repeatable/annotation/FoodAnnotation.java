package com.liumapp.blog.annotation.repeatable.annotation;

import java.lang.annotation.*;

/**
 * @author liumapp
 * @file FoodAnnotation.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/26/18
 */
@Repeatable(FoodsAnnotation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FoodAnnotation {

    public String name () default "apple";

}
