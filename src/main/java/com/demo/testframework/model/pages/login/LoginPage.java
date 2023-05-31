package com.demo.testframework.model.pages.login;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.testframework.core.report.TestReporter;
import com.demo.testframework.model.pages.BasePage;
import com.demo.testframework.model.pages.main.MainPage;
import com.demo.testframework.model.properties.PropertiesData;
import org.apache.log4j.chainsaw.Main;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.demo.testframework.model.providers.DataProviders.getValue;

@Component
public class LoginPage extends BasePage<LoginPage> {
    public static final String PAGE_NAME = "login_page";
    private static final By SUBMIT_BUTTON_ELEMENT = Selectors.byId(getValue(PAGE_NAME, "login_button"));
    private final SelenideElement loginField = $(Selectors.byXpath(getValue(PAGE_NAME, "login")));
    private final SelenideElement passwordField = $(Selectors.byXpath(getValue(PAGE_NAME, "password")));
    private final SelenideElement submitButton = $(SUBMIT_BUTTON_ELEMENT);

    public LoginPage() {
        super(PropertiesData.ENVIRONMENT_URL, SUBMIT_BUTTON_ELEMENT);
    }

    /**
     * Login to system.
     *
     * @param username client username
     * @param password client password
     * @return main page instance
     */
    public MainPage login(String username, String password) {
        TestReporter.reportDebugStep("Username has been logged in : %s ", username);
        return new MainPage();
    }
}
