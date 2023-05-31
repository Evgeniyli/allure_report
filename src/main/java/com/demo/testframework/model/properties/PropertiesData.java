package com.demo.testframework.model.properties;

import com.demo.testframework.core.exceptions.ExceptionError;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.demo.testframework.model.providers.DataProviders.getEnvValue;

public class PropertiesData {
    public static String ENVIRONMENT_URL = getEnvValue("url", "url_env");
    private static Properties seleniumProperty;
    private static Map<String, String> settings;

    public static void initializeProperties() {
        settings = new HashMap<>();
        seleniumProperty = new Properties();
        try {
            seleniumProperty.load(PropertiesData.class.getClassLoader().getResourceAsStream("properties/selenium.server.properties"));
            settings.put("server", String.valueOf(seleniumProperty.get(System.getProperty("server"))));
        } catch (IOException e) {
            throw new ExceptionError("Property initialization error, ", e.getCause());
        }
    }

    /**
     * Get server property value by id key
     *
     * @return property value  by key
     */
    public static String getProperty(String key) {
        initializeProperties();
        return settings.get(key);
    }
}
