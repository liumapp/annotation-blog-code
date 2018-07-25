package com.liumapp.blog.annotation.basic.annotation;

import java.lang.annotation.*;

/**
 * @author liumapp
 * @file HumanAnnotation.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/25/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
public @interface HumanAnnotation {

    String name ();

    String sex ();

    int age ();

}
