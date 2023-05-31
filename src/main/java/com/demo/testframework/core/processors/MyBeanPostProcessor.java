package com.demo.testframework.core.processors;

import com.demo.testframework.core.report.TestReporter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object object, String name) throws BeansException {
        TestReporter.reportInfoStep("postProcessAfterInitialization(): " + object);
        return object;
    }

    @Override
    public Object postProcessBeforeInitialization(Object object, String name) throws BeansException {
        return object;
    }
}
