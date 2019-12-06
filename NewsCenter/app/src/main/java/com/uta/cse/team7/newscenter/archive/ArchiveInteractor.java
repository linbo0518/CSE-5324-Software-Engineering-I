package com.uta.cse.team7.newscenter.archive;

import android.content.Context;

import com.uta.cse.team7.newscenter.models.FeedItem;
import com.uta.cse.team7.newscenter.utils.DatabaseUtil;

import java.util.List;

public class ArchiveInteractor implements IArchiveInteractor {
    public void retrieveArchiveFromDb(OnArticleRetrievedListener onArticleRetrievedListener, Context context) {
        DatabaseUtil databaseUtil = new DatabaseUtil(context);
        try {
            List<FeedItem> feedItems = databaseUtil.getSavedArticles();
            onArticleRetrievedListener.onSuccess(feedItems);
        } catch (Exception e) {
            e.printStackTrace();
            onArticleRetrievedListener.onFailure(e.getMessage());
        }
    }
}
