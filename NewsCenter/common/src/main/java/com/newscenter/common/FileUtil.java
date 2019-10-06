package com.newscenter.common;

import android.content.Context;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class FileUtil {

    public static String readAssetFie(Context context, String filePath) {
        int len;
        byte[] buf;
        String result = "";
        InputStream in = null;
        try {
            in = context.getAssets().open(filePath);
            len = in.available();
            buf = new byte[len];
            in.read(buf, 0, len);
            result = new String(buf, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
        return result;
    }
}
