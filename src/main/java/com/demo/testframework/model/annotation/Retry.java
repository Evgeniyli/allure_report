package com.demo.testframework.model.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Retry {

    /**
     * Check if need retry for test or not
     *
     * @return true if test use retry after failing, false otherwise
     */
    boolean isRetry();


}