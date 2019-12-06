package com.uta.cse.team7.newscenter.feeds;

import com.uta.cse.team7.newscenter.models.FeedItem;

import java.util.List;

public interface IFeedsView {
    void feedsLoaded(List<FeedItem> feedItems);

    void loadingFailed(String message);
}
