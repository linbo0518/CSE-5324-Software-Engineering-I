package com.newscenter.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    private static final SimpleDateFormat RFC822 = new SimpleDateFormat(
            "EEE, dd MMM yyyy HH:mm:ss Z", java.util.Locale.ENGLISH);

    public static Date parseRfc822(String date) {
        try {
            return RFC822.parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }
}
