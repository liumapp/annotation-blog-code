package com.liumapp.blog.annotation.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liumapp
 * @file TestDeprecated.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/25/18
 */
public class TestDeprecated {

    private Logger logger = LoggerFactory.getLogger(TestDeprecated.class);

    @Deprecated
    public void wrongMethod () {
        logger.warn("wrong method had been called");
    }

    public void correctMethod () {
        logger.info("hello world");
    }

}
