package com.uta.cse.team7.rssmanager;

import java.util.List;

public interface OnRssLoadListener {
    void onSuccess(List<RssItem> rssItems);

    void onFailure(String message);
}
