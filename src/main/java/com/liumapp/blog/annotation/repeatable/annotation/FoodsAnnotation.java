package com.liumapp.blog.annotation.repeatable.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author liumapp
 * @file FoodsAnnotation.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/26/18
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface FoodsAnnotation {

    FoodAnnotation[] value();

}
