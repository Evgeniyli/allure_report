package com.demo.testframework.core.driver;

import com.codeborne.selenide.WebDriverRunner;
import com.demo.testframework.core.exceptions.ExceptionError;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.asynchttpclient.util.HttpConstants.Methods.OPTIONS;

public class WebDriverHolder {
    private static final ThreadLocal<WebDriver> DRIVER_HOLDER = new ThreadLocal<>();

    /**
     * Web com.demo.testframework.core.driver constructor
     *
     * @param browser browser value
     * @param hub     hub server
     */
    public WebDriverHolder(String browser, String hub) {
        this.setDriver(browser, hub);
    }

    /**
     * Set web com.demo.testframework.core.driver to thread local holder.
     *
     * @param browser web com.demo.testframework.core.driver instance
     * @param hub     hub ip instance
     */
    private void setDriver(String browser, String hub) {
        WebDriver driver;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(OPTIONS);
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", false);
            desiredCapabilities.setCapability("selenoid:options", selenoidOptions);
            driver = new RemoteWebDriver(getUrl(hub), desiredCapabilities);
            WebDriverRunner.setWebDriver(driver);
            DRIVER_HOLDER.set(driver);
        } else {
            throw new ExceptionError("there are not correct browser for web driver initialization");
        }
        getDriver().manage().window().maximize();
    }

    /**
     * Getting thread-safe web com.demo.testframework.core.driver instance.
     *
     * @return web com.demo.testframework.core.driver instance
     */

    public static WebDriver getDriver() {
        return DRIVER_HOLDER.get();
    }

    /**
     * Quit work of web driver.
     * Remove web driver instance from thread local holder.
     */
    public static void closeDriver() {
        try {
            if (Objects.nonNull(DRIVER_HOLDER.get())) {
                DRIVER_HOLDER.get().quit();
                DRIVER_HOLDER.remove();
            }
        } catch (WebDriverException exception) {

        }
    }

    private URL getUrl(String hub) {
        try {
            return new URL(hub);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Set web driver holder by session id
     *
     * @param sessionId session id
     */
    public static void setDriverHolder(String sessionId) {
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("session_exp");
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("SessionId");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("SessionId", sessionId));
    }
}
