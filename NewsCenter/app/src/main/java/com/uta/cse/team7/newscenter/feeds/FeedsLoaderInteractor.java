package com.uta.cse.team7.newscenter.feeds;

import android.content.Context;
import android.util.Log;

import com.uta.cse.team7.newscenter.models.FeedItem;
import com.uta.cse.team7.newscenter.models.SourceItem;
import com.uta.cse.team7.newscenter.utils.DatabaseUtil;
import com.uta.cse.team7.newscenter.utils.DateUtil;
import com.uta.cse.team7.rssmanager.OnRssLoadListener;
import com.uta.cse.team7.rssmanager.RssItem;
import com.uta.cse.team7.rssmanager.RssReader;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class FeedsLoaderInteractor implements IFeedsLoaderInteractor, OnRssLoadListener {

    private Context mContext;
    private OnFeedsLoadedListener onFeedsLoadedListener;

    public FeedsLoaderInteractor(Context context) {
        mContext = context;
    }

    public void loadFeedsFromDb(final OnFeedsLoadedListener onFeedsLoadedListener) {
        try {
            DatabaseUtil databaseUtil = new DatabaseUtil(mContext);
            onFeedsLoadedListener.onSuccess(databaseUtil.getAllFeeds(), false);
        } catch (Exception e) {
            onFeedsLoadedListener.onFailure("读取失败");
        }
    }

    public void loadFeedsFromDbBySource(final OnFeedsLoadedListener onFeedsLoadedListener, String source) {
        try {
            DatabaseUtil databaseUtil = new DatabaseUtil(mContext);
            onFeedsLoadedListener.onSuccess(databaseUtil.getFeedsBySource(source), false);
        } catch (Exception e) {
            onFeedsLoadedListener.onFailure("读取失败");
        }
    }

    public void loadFeedsAsync(final OnFeedsLoadedListener onFeedsLoadedListener, List<SourceItem> sourceItems) {
        this.onFeedsLoadedListener = onFeedsLoadedListener;

        String[] urlList = new String[sourceItems.size()];
        String[] sourceList = new String[sourceItems.size()];
        String[] categories = new String[sourceItems.size()];
        int[] categoryImgIds = new int[sourceItems.size()];
        for (int i = 0; i < urlList.length; i++) {
            urlList[i] = sourceItems.get(i).getSourceUrl();
            sourceList[i] = sourceItems.get(i).getSourceName();
            categories[i] = sourceItems.get(i).getSourceCategoryName();
            categoryImgIds[i] = sourceItems.get(i).getSourceCategoryImgId();
        }
        Log.e("url", urlList[0]);
        RssReader rssReader = new RssReader(mContext, urlList, sourceList, categories, categoryImgIds, this);
        rssReader.readRssFeeds();
    }

    private FeedItem getFeedItem(String title, String description, String link, String imgUrl, String sourceName, String sourceUrlShort, String category, String pubDate, int categoryImgId) {
        FeedItem feedItem = new FeedItem();
        feedItem.setItemTitle(title);
        feedItem.setItemDesc(description);
        feedItem.setItemLink(link);
        feedItem.setItemImgUrl(imgUrl);
        feedItem.setItemSource(sourceName);
        feedItem.setItemSourceUrl(sourceUrlShort);
        feedItem.setItemCategory(category);
        feedItem.setItemPubDate(pubDate);
        feedItem.setItemCategoryImgId(categoryImgId);
        return feedItem;
    }

    @Override
    public void onSuccess(List<RssItem> rssItems) {
        List<FeedItem> feedItems = new ArrayList<>();
        for (RssItem rssItem : rssItems) {
            String title = rssItem.getTitle();
            String description = rssItem.getDescription();
            String link = rssItem.getLink();
            String imgUrl = rssItem.getImageUrl();
            String sourceName = rssItem.getSourceName();
            String sourceUrlShort = rssItem.getSourceUrl();
            String category = rssItem.getCategory();
            String pubDate = rssItem.getPubDate();
            int categoryImgId = rssItem.getCategoryImgId();

            try {
                pubDate = new DateUtil().getDate(pubDate);
            } catch (ParseException e) {
                e.printStackTrace();
                pubDate = "无时间";
            }

            FeedItem feedItem = getFeedItem(title, description, link, imgUrl, sourceName, sourceUrlShort, category, pubDate, categoryImgId);
            feedItems.add(feedItem);
        }
        onFeedsLoadedListener.onSuccess(feedItems, true);
    }

    @Override
    public void onFailure(String message) {
        onFeedsLoadedListener.onFailure(message);
    }
}
