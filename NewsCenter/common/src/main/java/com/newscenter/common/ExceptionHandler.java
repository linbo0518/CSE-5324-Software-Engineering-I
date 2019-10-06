package com.newscenter.common;

import android.content.ActivityNotFoundException;

public class ExceptionHandler {

    public static void silentHandle(Exception e) {
        if (e instanceof ActivityNotFoundException) {

        }
    }
}
