package com.newscenter.common;

import android.content.Context;
import android.content.pm.PackageManager;

public class AppUtil {
    public static boolean isAppInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        boolean installed;
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        } catch (RuntimeException e) {
            installed = false;
        }
        return installed;
    }
}
