package com.demo.testframework.core.utils;

import java.util.concurrent.TimeUnit;

public class WaitingUtils {

    /**
     * Make a delay
     *
     * @param time     time
     * @param timeUnit time unit
     */
    public static void delay(long time, TimeUnit timeUnit) {
        try {
            Thread.sleep(timeUnit.toMillis(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

