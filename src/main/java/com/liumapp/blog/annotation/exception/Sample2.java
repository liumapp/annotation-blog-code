package com.liumapp.blog.annotation.exception;

import com.liumapp.blog.annotation.exception.annotation.ExceptionTest;

/**
 * @author liumapp
 * @file Sample2.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/24/18
 */
public class Sample2 {

    /**
     * exception should pass
     * correct exception
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m1 () {
        int i = 0;
        i = 1 / i;
    }

    /**
     * exception should fail
     * wrong exception
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m2 () {
        int[] a = new int[0];
        int i = a[1];
    }

    /**
     * exception should fail
     * no exception
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m3 () {}

}
