package com.uta.cse.team7.newscenter.archive;

import com.uta.cse.team7.newscenter.models.FeedItem;

import java.util.List;

public interface OnArticleRetrievedListener {
    void onSuccess(List<FeedItem> feedItems);

    void onFailure(String message);
}
