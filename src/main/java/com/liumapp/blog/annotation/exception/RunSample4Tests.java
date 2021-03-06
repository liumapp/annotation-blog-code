package com.liumapp.blog.annotation.exception;

import com.liumapp.blog.annotation.exception.annotation.SpecifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author liumapp
 * @file RunSample4Tests.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 7/25/18
 */
public class RunSample4Tests {

    public static Logger logger = LoggerFactory.getLogger(RunSample4Tests.class);

    public static void main (String[] args) {
        Sample4 sample4 = new Sample4();
        Class clazz = sample4.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        StringBuffer logs = new StringBuffer();
        int errorNum = 0;
        for (Method m : methods) {
            if (m.isAnnotationPresent(SpecifyException.class)) {
                try {
                    m.setAccessible(true);
                    m.invoke(sample4, null);
                } catch (Exception e) {
                    errorNum++;
                    logs.append(m.getName());
                    logs.append("   ");
                    logs.append("\n\r caused by : ");
                    logs.append(e.getCause().getClass().getSimpleName());
                    logs.append("\n\r");
                    logs.append(e.getCause().getMessage());
                    logs.append("\n\r");
                }
            }
        }
        logs.append(clazz.getSimpleName());
        logs.append(" has ");
        logs.append(errorNum);
        logs.append(" error.");
        logger.info(logs.toString());
    }

}
