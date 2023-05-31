package com.demo.testframework.core.report;

import com.demo.testframework.core.utils.DateUtils;
import com.demo.testframework.core.utils.MessageColour;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestReporter {

    public static final Logger logger = LogManager.getLogger(TestReporter.class);
    private static final String DEBUG_STATUS = "debug";
    private static final String ERROR_STATUS = "error";
    private static final String INFO_STATUS = "info";
    private final String pattern = DateUtils.MONTH_NUMBER_FORM + "-" + DateUtils.DAY + "-" + DateUtils.YEAR + " " + DateUtils.HOUR_24_FORMAT + ":" + DateUtils.MINUTE +
            ":" + DateUtils.SECOND + " " + DateUtils.AM_PM_MARKER;
    private final String timeStep = DateUtils.getDateTime(DateUtils.getCurrentTimeZone(), pattern, 0);

    /**
     * Report debug step
     *
     * @param debugStepMessage debug message
     * @param parameters       message constructing parameters
     * @see String#format
     */
    public static void reportDebugStep(String debugStepMessage, Object... parameters) {
        String message = String.format(new TestReporter().timeStep + " - " + debugStepMessage, parameters);
        checkLoggerStatus("true", DEBUG_STATUS, String.format(debugStepMessage, getParametersByNewObject(parameters)));
        reportAllureStep(message);
    }

    /**
     * Report error step
     *
     * @param errorStepMessage error message
     * @param parameters       message constructing parameters
     * @see String#format
     */
    public static void reportErrorStep(String errorStepMessage, Object... parameters) {
        String message = String.format(new TestReporter().timeStep + " - " + errorStepMessage, parameters);
        checkLoggerStatus("true", ERROR_STATUS, String.format(errorStepMessage, getParametersByNewObject(parameters)));
        reportAllureStep(message);
    }

    /**
     * com.demo.testframework.core.driver.report info step
     *
     * @param infoStepMessage error message
     * @param parameters      message constructing parameters
     * @see String#format
     */
    public static void reportInfoStep(String infoStepMessage, Object... parameters) {
        String message = String.format(new TestReporter().timeStep + " - " + infoStepMessage, parameters);
        checkLoggerStatus("true", INFO_STATUS, String.format(infoStepMessage, getParametersByNewObject(parameters)));
        reportAllureStep(message);
    }


    private static void checkLoggerStatus(String status, String loggerInfo, String message) {
        if (status.equals("true") && loggerInfo.equals("debug")) {
            logger.debug(message);
        }
        if (status.equals("true") && loggerInfo.equals("error")) {
            logger.error(message);
        }
        if (status.equals("true") && loggerInfo.equals("info")) {
            logger.info(message);
        }
    }
    @Step("{0}")
    private static void reportAllureStep(String stepMessage) {

    }


    /**
     * Get parameter for console with color by creation new object
     *
     * @param parameters logger
     * @return new instance
     */
    public static Object[] getParametersByNewObject(Object[] parameters) {
        Object[] newObject = new Object[parameters.length];
        String temp;
        for (int i = 0; i < parameters.length; i++) {
            temp = MessageColour.ANSI_YELLOW + parameters[i] + MessageColour.ANSI_CYAN;
            newObject[i] = temp;
        }
        return newObject;
    }

}
