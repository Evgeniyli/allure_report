package com.demo.testframework.model.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationInitContext {
    private static AnnotationConfigApplicationContext annotationConfigApplicationContext;

    public static AnnotationConfigApplicationContext getAnnotationConfigApplicationContext() {
        return annotationConfigApplicationContext;
    }

    public static void initApplicationContext(Class<?>... classes) {
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(classes);
    }
}
