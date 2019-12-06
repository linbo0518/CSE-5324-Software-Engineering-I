package com.uta.cse.team7.newscenter.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    String formatRfc2822 = "EEE, dd MMM yyyy HH:mm:ss Z";
    String formatLocal = "yyyy-MM-dd HH:mm";
    private String date;

    public String getCurrDate() {
//        date = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss").format(new Date());
        date = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        return date;
    }

    //converts rss publish date into a readable format
    public String getDate(String pubDate) throws ParseException {
        Date date = getDateObj(pubDate);
        return new SimpleDateFormat(formatLocal).format(date);
    }

    //get Date object from pub date
    public Date getDateObj(String pubDate) throws ParseException {
        SimpleDateFormat pubDateFormat = new SimpleDateFormat(formatRfc2822, Locale.ENGLISH); //rss spec
        Date date = null;
        try {
            date = pubDateFormat.parse(pubDate);
        } catch (ParseException e) {
            pubDateFormat = new SimpleDateFormat(formatLocal); //fallback
            date = pubDateFormat.parse(pubDate);
        }
        return date;
    }
}
