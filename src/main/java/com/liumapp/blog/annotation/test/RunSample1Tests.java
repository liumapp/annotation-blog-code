package com.liumapp.blog.annotation.test;

import com.liumapp.blog.annotation.test.annotation.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liumapp
 * @file RunTests.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/24/18
 */
public class RunSample1Tests {

    private static Logger logger = LoggerFactory.getLogger(RunSample1Tests.class);

    public static void main (String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(Sample.class.getName());
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException e1) {
                    Throwable exc = e1.getCause();
                    logger.info(m + " failed : " + exc);
                } catch (Exception e2) {
                    logger.info("INVAILD @Test : " + m);
                }
            }
        }

        logger.info("Passed : " + passed + ", Failed: " + (tests - passed));

    }

}
