package com.demo.testframework.model.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DisableRunTestMethod {
    /**
     * Contains test case method name
     *
     * @return all environments list, which it will ignore after running
     */
    String[] environmentIgnoreList();
}
