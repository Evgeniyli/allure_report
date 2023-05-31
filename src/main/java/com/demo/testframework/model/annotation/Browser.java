package com.demo.testframework.model.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Browser {

    /**
     * Contains test browser name
     *
     * @return null if the values wasn't set
     */
    String name();
}
