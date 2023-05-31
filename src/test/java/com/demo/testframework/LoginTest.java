package com.demo.testframework;

import com.demo.testframework.core.report.TestReporter;
import com.demo.testframework.model.annotation.DisableRunTestMethod;
import com.demo.testframework.model.pages.login.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    @BeforeClass
    @Parameters({"userId"})
    public void initialization() {

    }

    @Test(groups = "smoke")
    @DisableRunTestMethod(environmentIgnoreList = {"stage"})
    @Issue("https://test.com")
    @Description("Login to system")
    @Severity(SeverityLevel.CRITICAL)
    public void testCase_loginSystemTestStage() {
     /*  new LoginPage().openWindow()
                .waitPageLoading(15, TimeUnit.SECONDS)
                .login("login1", "passwor222d")
                .navigateMainPage();*/
        TestReporter.reportDebugStep("Username has been logged in : %s ", "fdf");
    }

    @Test(groups = "smoke")
    @DisableRunTestMethod(environmentIgnoreList = {"prod"})
    @Issue("https://test2.com")
    @Description("Navigate to main page")
    @Severity(SeverityLevel.CRITICAL)
    public void testCase_loginSystemTestProd() {
        TestReporter.reportDebugStep("Username has been logged in : %s ", "fdf");
    }

    @Test(groups = "smoke")
    @DisableRunTestMethod(environmentIgnoreList = {"prod"})
    @Issue("https://test2.com")
    @Description("Navigate to main page")
    @Severity(SeverityLevel.CRITICAL)
    public void testCase_loginSystemTestUAT() {
        TestReporter.reportDebugStep("Username has been logged in : %s ", "Tedfsdf");
    }
}
