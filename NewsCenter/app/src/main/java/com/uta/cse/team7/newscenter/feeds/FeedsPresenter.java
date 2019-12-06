package com.uta.cse.team7.newscenter.feeds;

import android.content.Context;

import com.uta.cse.team7.newscenter.models.FeedItem;
import com.uta.cse.team7.newscenter.models.SettingsPreferences;
import com.uta.cse.team7.newscenter.models.SourceItem;
import com.uta.cse.team7.newscenter.utils.DatabaseUtil;
import com.uta.cse.team7.newscenter.utils.comparator.FeedCategoryComparator;
import com.uta.cse.team7.newscenter.utils.comparator.FeedPubDateComparator;
import com.uta.cse.team7.newscenter.utils.comparator.FeedTitleComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FeedsPresenter implements IFeedsPresenter, OnFeedsLoadedListener {

    private IFeedsView mIFeedsView;
    private FeedsLoaderInteractor mFeedsLoaderInteractor;
    private Context mContext;

    public FeedsPresenter(IFeedsView mIFeedsView, Context context) {
        this.mIFeedsView = mIFeedsView;
        this.mContext = context;
        this.mFeedsLoaderInteractor = new FeedsLoaderInteractor(context);
    }

    public void attemptFeedLoading() {
        try {
            List<SourceItem> sourceItems = new DatabaseUtil(mContext).getAllSources();
            mFeedsLoaderInteractor.loadFeedsAsync(this, sourceItems);
        } catch (Exception e) {
            e.printStackTrace();
            mIFeedsView.loadingFailed(e.getMessage());
        }
    }

    public void attemptFeedLoading(String source) {
        try {
            SourceItem sourceItem = new DatabaseUtil(mContext).getSourceItem(source);
            List<SourceItem> sourceItems = new ArrayList<>();
            sourceItems.add(sourceItem);
            mFeedsLoaderInteractor.loadFeedsAsync(this, sourceItems);
        } catch (Exception e) {
            e.printStackTrace();
            mIFeedsView.loadingFailed(e.getMessage());
        }
    }

    public void attemptFeedLoadingFromDb() {
        mFeedsLoaderInteractor.loadFeedsFromDb(this);
    }

    public void attemptFeedLoadingFromDbBySource(String source) {
        mFeedsLoaderInteractor.loadFeedsFromDbBySource(this, source);
    }


    public void deleteFeeds() {
        DatabaseUtil databaseUtil = new DatabaseUtil(mContext);
        try {
            databaseUtil.deleteAllFeeds();
            mIFeedsView.feedsLoaded(null);
        } catch (Exception e) {
            e.printStackTrace();
            mIFeedsView.loadingFailed(e.getMessage());
        }
    }

    public void deleteSelectedFeed(FeedItem feedItem) {
        DatabaseUtil databaseUtil = new DatabaseUtil(mContext);
        try {
            databaseUtil.deleteSelectedFeeds(feedItem);
        } catch (Exception e) {
            e.printStackTrace();
            mIFeedsView.loadingFailed(e.getMessage());
        }
    }

    @Override
    public void onSuccess(List<FeedItem> feedItems, boolean loadedNewFeeds) {
        //sort the list
        switch (SettingsPreferences.getSortingMethod(mContext)) {
            case "random":
                Collections.shuffle(feedItems, new Random(System.nanoTime()));
                break;
            case "feed_title":
                Collections.sort(feedItems, new FeedTitleComparator());
                break;
            case "feed_category":
                Collections.sort(feedItems, new FeedCategoryComparator());
                break;
            case "feed_pub_date":
                Collections.sort(feedItems, new FeedPubDateComparator());
                break;
        }
        mIFeedsView.feedsLoaded(feedItems);
        if (loadedNewFeeds && SettingsPreferences.FEED_CACHE) {
            new DatabaseUtil(mContext).saveFeedsInDB(feedItems);
        }
    }

    @Override
    public void onFailure(String message) {
        mIFeedsView.loadingFailed(message);
    }
}
