package listeners;

import com.demo.testframework.BaseTest;
import com.demo.testframework.core.report.TestReporter;
import com.demo.testframework.model.context.ApplicationInitContext;
import com.demo.testframework.model.pages.login.LoginPage;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.*;
import org.testng.internal.IResultListener2;

import static com.demo.testframework.core.driver.WebDriverHolder.closeDriver;
import static com.demo.testframework.model.properties.PropertiesData.getProperty;


public class ApplicationTestListener extends TestListenerAdapter implements IReporter, IExecutionListener, ISuiteListener, IResultListener2 {

    private final AllureTestNg allureTestNg = new AllureTestNg();
    private final BaseTest baseTest = new BaseTest();

    @Override
    public void onExecutionStart() {
//        ApplicationInitContext.initApplicationContext(LoginPage.class);
    }


    @Override
    public void onStart(ISuite suite) {
        allureTestNg.onStart(suite);
    }

    @Override
    public void onStart(ITestContext testContext) {
        allureTestNg.onStart(testContext);
    }

    @Override
    public void onTestStart(ITestResult testResult) {
        baseTest.initDriver("chrome", getProperty("server"));
        allureTestNg.onTestStart(testResult);
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        allureTestNg.onTestSuccess(testResult);
        TestReporter.logger.info("Test was successfully completed: " + testResult.getName());
        closeDriver();
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        allureTestNg.onTestSkipped(testResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
        allureTestNg.onTestFailedButWithinSuccessPercentage(testResult);
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        allureTestNg.onTestFailure(testResult);
        closeDriver();
    }

    @Override
    public void onConfigurationFailure(ITestResult testResult) {
        isConfigurationMethodFailed(testResult);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        allureTestNg.onFinish(testContext);
    }

    @Override
    public void onFinish(ISuite suite) {
        allureTestNg.onFinish(suite);
    }

    private void isConfigurationMethodFailed(ITestResult testResult) {
        testResult.setParameters(new Object[0]);
        if (testResult.getMethod().getMethodName().equalsIgnoreCase("terminate")
                || testResult.getMethod().getMethodName().equalsIgnoreCase("initialization")) {
            testResult.setStatus(ITestResult.SUCCESS);
        } else {
            testResult.setStatus(ITestResult.FAILURE);
        }
        Reporter.setCurrentTestResult(testResult);
    }
}