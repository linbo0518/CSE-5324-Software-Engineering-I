package com.uta.cse.team7.newscenter.utils;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlUtil {
    public static String REGEX_URL = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public static String getWebsiteName(String url) {
        URI uri;
        try {
            uri = new URI(url);
            return uri.getHost();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return url;
    }
}
