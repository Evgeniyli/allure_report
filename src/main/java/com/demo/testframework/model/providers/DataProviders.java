package com.demo.testframework.model.providers;

import com.demo.testframework.core.parser.JSONParserUtils;
import java.util.Map;
import java.util.Objects;


public class DataProviders {
    public static final String ENV_NAME_FOLDER = "src/main/resources/data_environment/stage/base.json";
    private static Map<String, Map<String, String>> elementsStore = null;
    private final static String JSON_FILE_NAME = "src/main/resources/data_environment/stage/data_web_elements/data_web_elements.json";

    /**
     * Get value by keys for new UI
     *
     * @param pageName    JSON object
     * @param elementName JSON object field
     * @return value of the specified parameters
     */
    public static String getValue(String pageName, String elementName) {
        if (elementsStore == null) {
            elementsStore = JSONParserUtils.parseJSON(JSON_FILE_NAME);
        }
        return Objects.requireNonNull(elementsStore).get(pageName).get(elementName);
    }


    /**
     * Get value by keys for specified environment
     *
     * @param pageName    JSON object
     * @param elementName JSON object field
     * @return value of the specified parameters
     */
    public static String getEnvValue(String pageName, String elementName) {
        String value;
        value = Objects.requireNonNull(JSONParserUtils.parseJSON(ENV_NAME_FOLDER))
                .get(pageName)
                .get(elementName);
        if (value == null) {
            throw new NullPointerException(String.format("%s elementName is not exist in pageName=%s", elementName, pageName));
        }
        if (value.equalsIgnoreCase("null")) {
            return null;
        }
        return value;
    }
}
