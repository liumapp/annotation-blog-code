package com.liumapp.blog.annotation.test;

import com.liumapp.blog.annotation.test.annotation.Test;

/**
 * @author liumapp
 * @file Sample.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/24/18
 */
public class Sample {

    @Test
    public static void m1 () {}

    public static void m2 () {}

    @Test
    public static void m3 () {
        throw new RuntimeException("m3 exception");
    }

    public static void m4 () {}

    @Test
    public void m5 () {}

    public static void m6 () {}

    @Test
    public static void m7 () {
        throw new RuntimeException("m7 exception");
    }

    public static void m8 () {}

}
