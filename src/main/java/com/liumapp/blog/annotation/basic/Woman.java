package com.liumapp.blog.annotation.basic;

import com.liumapp.blog.annotation.basic.annotation.FoodAnnotation;
import com.liumapp.blog.annotation.basic.annotation.HumanAnnotation;
import com.liumapp.blog.annotation.basic.annotation.MoveFasterAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liumapp
 * @file Woman.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/25/18
 */
@HumanAnnotation(name = "XiaoJu", sex = "girl", age = 18)
public class Woman {

    private static Logger logger = LoggerFactory.getLogger(Woman.class);

    @FoodAnnotation("apple")
    private String lovesFood;

    @MoveFasterAnnotation
    private void walk () {}

    @SuppressWarnings("deprecation")
    public void wrongMethod () {
        TestDeprecated testDeprecated = new TestDeprecated();
        testDeprecated.wrongMethod();
        testDeprecated.correctMethod();
    }

    public static void main (String[] args) {
        boolean hasAnnotation = Woman.class.isAnnotationPresent(HumanAnnotation.class);

        if (hasAnnotation) {
            HumanAnnotation humanAnnotation = Woman.class.getAnnotation(HumanAnnotation.class);
            logger.info("a human named: " + humanAnnotation.name());
            logger.info("a human who is a: " + humanAnnotation.sex());
            logger.info("a human who is:" + humanAnnotation.age() + " years old");
        }

        try {
            Field food = Woman.class.getDeclaredField("lovesFood");
            food.setAccessible(true);

            FoodAnnotation foodAnnotation = food.getAnnotation(FoodAnnotation.class);

            if (foodAnnotation != null) {
                logger.info("the human loves to eat: " + foodAnnotation.value());
            }

            Method method = Woman.class.getDeclaredMethod("walk");

            if (method != null) {
                Annotation[] ans = method.getDeclaredAnnotations();
                for (Annotation annotation : ans) {
                    logger.info("the human has method: " + annotation.annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
