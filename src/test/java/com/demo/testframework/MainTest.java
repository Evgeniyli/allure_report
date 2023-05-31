package com.demo.testframework;

import com.demo.testframework.model.pages.login.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class MainTest extends BaseTest {


    @BeforeClass
    @Parameters({"userId"})
    public void initialization() {

    }

    @Test(groups = "sanity")
    @Issue("https://test.com")
    @Description("Navigate to main page")
    @Severity(SeverityLevel.CRITICAL)
    public void test_context2Loads() {
        new LoginPage().openWindow()
                .waitPageLoading(15, TimeUnit.SECONDS)
                .login("login", "password")
                .navigateMainPage();
    }
}
