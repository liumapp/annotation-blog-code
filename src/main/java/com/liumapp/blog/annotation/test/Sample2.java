package com.liumapp.blog.annotation.test;

import com.liumapp.blog.annotation.test.annotation.ExceptionTest;

/**
 * @author liumapp
 * @file Sample2.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/24/18
 */
public class Sample2 {

    /**
     * test should pass
     * correct exception
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m1 () {
        int i = 0;
        i = 1 / i;
    }

    /**
     * test should fail
     * wrong exception
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m2 () {
        int[] a = new int[0];
        int i = a[1];
    }

    /**
     * test should fail
     * no exception
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m3 () {}

}
