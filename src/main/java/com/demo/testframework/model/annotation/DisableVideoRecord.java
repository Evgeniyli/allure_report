package com.demo.testframework.model.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DisableVideoRecord {

    /**
     * Contains test case method name
     *
     * @return false if video record should disable
     */
    boolean isDisableVideoRecord();
}
