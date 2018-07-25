package com.liumapp.blog.annotation.exception;

import com.liumapp.blog.annotation.exception.annotation.MultyExceptionTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author liumapp
 * @file RunSample3Tests.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/24/18
 */
public class RunSample3Tests {

    private static Logger logger = LoggerFactory.getLogger(RunSample2Tests.class);

    public static void main (String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(Sample3.class.getName());
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(MultyExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    logger.error("Test " + m + " failed: no exception");
                } catch (Throwable e1) {
                    Throwable exc = e1.getCause();
                    Class<? extends Exception>[] excTypes = m.getAnnotation(MultyExceptionTest.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        logger.info("Test " + m + " failed : " + exc);
                    }
                }
            }
        }

        logger.info("Passed : " + passed + ", Failed: " + (tests - passed));

    }

}
