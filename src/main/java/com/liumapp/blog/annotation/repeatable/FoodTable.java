package com.liumapp.blog.annotation.repeatable;


import com.liumapp.blog.annotation.repeatable.annotation.FoodAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author liumapp
 * @file FoodTable.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/26/18
 */
@FoodAnnotation(name = "rice")
@FoodAnnotation(name = "orange")
@FoodAnnotation(name = "banana")
public class FoodTable {

    private static Logger logger = LoggerFactory.getLogger(FoodTable.class);

    public static void main (String[] args) {
        Class clazz = FoodTable.class;
        boolean hasAnnotation = clazz.isAnnotationPresent(FoodAnnotation.class);
        if (hasAnnotation) {
            FoodAnnotation[] foodAnnotations = (FoodAnnotation[]) clazz.getDeclaredAnnotations();
            for (FoodAnnotation foodAnnotation : foodAnnotations) {
                logger.info("found food : " + foodAnnotation.name());
            }
        }
    }

}
