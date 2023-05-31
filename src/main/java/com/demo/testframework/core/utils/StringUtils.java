package com.demo.testframework.core.utils;


import java.util.Calendar;
import java.util.Date;

public class StringUtils {

    public static String getRandomNumber() {
        String datePattern = DateUtils.DAY + DateUtils.MONTH_NUMBER_FORM + DateUtils.YEAR_SHORT_FORM;
        return DateUtils.getDateTime(DateUtils.EET_TIME_ZONE, datePattern, getCalendarDateTime()) + (int) (Math.random() * 99999);
    }

    private static Calendar getCalendarDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 0);
        return calendar;
    }
}




