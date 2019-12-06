package com.uta.cse.team7.newscenter.feeds;

import com.uta.cse.team7.newscenter.models.FeedItem;

/**
 * Created by Kartik_ch on 11/4/2015.
 */
public interface IFeedsPresenter {
    void attemptFeedLoading();

    void attemptFeedLoading(String source);

    void attemptFeedLoadingFromDb();

    void attemptFeedLoadingFromDbBySource(String source);

    void deleteFeeds();

    void deleteSelectedFeed(FeedItem feedItem);
}
