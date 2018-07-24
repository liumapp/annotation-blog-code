package com.liumapp.blog.annotation.test;

import com.liumapp.blog.annotation.test.annotation.ExceptionTest;
import com.liumapp.blog.annotation.test.annotation.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liumapp
 * @file RunSample2Tests.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/24/18
 */
public class RunSample2Tests {

    private static Logger logger = LoggerFactory.getLogger(RunSample2Tests.class);

    public static void main (String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(Sample2.class.getName());
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    logger.error("Test " + m + " failed: no exception");
                } catch (InvocationTargetException e1) {
                    Throwable exc = e1.getCause();
                    Class<? extends Exception> excType = m.getAnnotation(ExceptionTest.class).value();
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        logger.info("Tests " + m + " failed : expected" + excType.getName() + " , got " + exc);
                    }
                } catch (Exception e2) {
                    logger.info("INVAILD @Test : " + m);
                }
            }
        }

        logger.info("Passed : " + passed + ", Failed: " + (tests - passed));

    }

}
