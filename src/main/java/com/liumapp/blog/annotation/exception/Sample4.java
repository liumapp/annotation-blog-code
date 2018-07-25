package com.liumapp.blog.annotation.exception;

import com.liumapp.blog.annotation.exception.annotation.SpecifyException;

/**
 * @author liumapp
 * @file Sample4.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/25/18
 */
public class Sample4 {

    @SpecifyException
    public void show(){
        System.out.println("1234567890");
    }

    @SpecifyException
    public void add(){
        System.out.println("1+1="+1+1);
    }

    @SpecifyException
    public void sub(){
        System.out.println("1-1="+(1-1));
    }

    @SpecifyException
    public void multy(){
        System.out.println("3 x 5="+ 3*5);
    }

    @SpecifyException
    public void divi(){
        System.out.println("6 / 0="+ 6 / 0);
    }

}
