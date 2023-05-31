package com.demo.testframework;

import com.codeborne.selenide.Configuration;
import com.demo.testframework.core.driver.WebDriverHolder;
import listeners.ApplicationTestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({ApplicationTestListener.class})
public class BaseTest {

    @BeforeClass
    public void init() {
        Configuration.timeout = 60000;
    }

    public void initDriver(String browserValue, String hub) {
//        new WebDriverHolder(browserValue, hub);
    }
}