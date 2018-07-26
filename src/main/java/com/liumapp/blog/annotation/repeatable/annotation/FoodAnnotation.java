package com.liumapp.blog.annotation.repeatable.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author liumapp
 * @file FoodAnnotation.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/26/18
 */
@Repeatable(FoodsAnnotation.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FoodAnnotation {

    public String name () default "apple";

}
