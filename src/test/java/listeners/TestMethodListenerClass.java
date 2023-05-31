package listeners;

import com.demo.testframework.core.report.TestReporter;
import com.demo.testframework.model.annotation.DisableRunTestMethod;
import lombok.Synchronized;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestMethodListenerClass implements IAnnotationTransformer {

    public static final String ENVIRONMENT = System.getProperty("env");

    @Override
    @Synchronized
    public void transform(ITestAnnotation testAnnotation, Class aClass, Constructor constructor, Method testMethod) {
        DisableRunTestMethod disableRunTestMethods = testMethod.getAnnotation(DisableRunTestMethod.class);
        if (disableRunTestMethods != null) {
            for (String environmentIgnore : disableRunTestMethods.environmentIgnoreList()) {
                if (environmentIgnore.equalsIgnoreCase(ENVIRONMENT)) {
                    testAnnotation.setEnabled(false);
                    TestReporter.logger.info(String.format("%s - test was disabled for %s environment",
                            testMethod.getName(), ENVIRONMENT));
                    return;
                }
            }
        }
    }
}
