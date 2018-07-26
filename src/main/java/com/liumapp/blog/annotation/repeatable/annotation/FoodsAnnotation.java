package com.liumapp.blog.annotation.repeatable.annotation;

/**
 * @author liumapp
 * @file FoodsAnnotation.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/26/18
 */
public @interface FoodsAnnotation {

    FoodAnnotation[] value();

}
