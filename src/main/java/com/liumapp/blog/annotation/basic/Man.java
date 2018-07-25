package com.liumapp.blog.annotation.basic;

import com.liumapp.blog.annotation.basic.annotation.HumanAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liumapp
 * @file Man.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/25/18
 */
@HumanAnnotation(name = "Zhangsan", sex = "boy", age = 18)
public class Man {

    private static Logger logger = LoggerFactory.getLogger(Man.class);

    public static void main (String[] args) {
        boolean hasAnnotation = Man.class.isAnnotationPresent(HumanAnnotation.class);
        if (hasAnnotation) {
            HumanAnnotation humanAnnotation = Man.class.getAnnotation(HumanAnnotation.class);
            logger.info("a human named :  " + humanAnnotation.name());
            logger.info("a human who is a : " + humanAnnotation.sex());
            logger.info("a human who is : " + humanAnnotation.age() + " years old");
        }
    }

}
