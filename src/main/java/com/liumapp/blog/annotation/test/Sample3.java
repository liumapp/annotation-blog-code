package com.liumapp.blog.annotation.test;

import com.liumapp.blog.annotation.test.annotation.MultyExceptionTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liumapp
 * @file Sample3.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/24/18
 */
public class Sample3 {

    @MultyExceptionTest({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyBad () {
        List<String> list = new ArrayList<String>();
        // throw either IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);
    }

}
