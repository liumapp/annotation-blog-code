package com.liumapp.blog.annotation.basic;

import com.liumapp.blog.annotation.basic.annotation.FoodAnnotation;
import com.liumapp.blog.annotation.basic.annotation.HumanAnnotation;
import com.liumapp.blog.annotation.basic.annotation.MoveFasterAnnotation;

/**
 * @author liumapp
 * @file Woman.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/25/18
 */
@HumanAnnotation(name = "XiaoJu", sex = "girl", age = 18)
public class Woman {

    @FoodAnnotation("apple")
    private String lovesFood;

    @MoveFasterAnnotation
    private void walk () {}

    

}
