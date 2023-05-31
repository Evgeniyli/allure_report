package listeners;

import com.demo.testframework.core.report.TestReporter;
import com.demo.testframework.model.annotation.Retry;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.concurrent.atomic.AtomicInteger;


public class RetryFailedTestCases implements IRetryAnalyzer {
    private static final int MAX_RETRY_COUNT = 1;
    private AtomicInteger count = new AtomicInteger(MAX_RETRY_COUNT);

    @Override
    public boolean retry(ITestResult testResult) {
        if (isRetryEnabled(testResult)) {
            testResult.setStatus(ITestResult.SKIP);
            Reporter.setCurrentTestResult(testResult);
            return false;
        }
        if (System.getProperty("suite.name") != null && System.getProperty("suite.name").contains("failed_")) {
            return false;
        }
        if (isRetryAvailable()) {
            TestReporter.logger.info("Going to retry Test Case: " + testResult.getName() + ", the test has " +
                    (MAX_RETRY_COUNT - count.intValue() + 1) + " of " + MAX_RETRY_COUNT + " attempts");
            count.decrementAndGet();
            return true;
        }
        return false;
    }

    private boolean isRetryEnabled(ITestResult result) {
        Retry retryAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Retry.class);
        return retryAnnotation != null;
    }

    private boolean isRetryAvailable() {
        return (count.intValue() > 0);
    }
}
