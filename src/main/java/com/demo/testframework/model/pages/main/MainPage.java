package com.demo.testframework.model.pages.main;

import com.codeborne.selenide.Selectors;
import com.demo.testframework.core.report.TestReporter;
import com.demo.testframework.model.pages.BasePage;
import org.openqa.selenium.By;

import static com.demo.testframework.model.providers.DataProviders.getValue;

public class MainPage extends BasePage<MainPage> {
    public static final String PAGE_NAME = "main_page";
    private static final By TITTLE = Selectors.byId(getValue(PAGE_NAME, "tittle"));

    public MainPage() {
        super(TITTLE);
    }

    /**
     * Navigate main page
     *
     * @return Schedule page instance
     */
    public MainPage navigateMainPage() {
        TestReporter.reportDebugStep("The main page was opened");
        return this;
    }
}
