package com.uta.cse.team7.rssmanager;

import org.jsoup.select.Elements;

public interface OnFeedLoadListener {
    void onSuccess(Elements elements);

    void onFailure(String message);
}
