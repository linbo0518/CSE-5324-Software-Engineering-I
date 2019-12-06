package com.uta.cse.team7.newscenter.feeds;

import com.uta.cse.team7.newscenter.models.FeedItem;

import java.util.List;

public interface OnFeedsLoadedListener {
    void onSuccess(List<FeedItem> feedItems, boolean loadedNewFeeds);

    void onFailure(String message);
}
