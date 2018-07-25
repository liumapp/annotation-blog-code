package com.liumapp.blog.annotation.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liumapp
 * @file MoveFasterAnnotation.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/25/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MoveFasterAnnotation {
}
