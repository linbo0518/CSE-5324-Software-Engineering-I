package com.uta.cse.team7.newscenter.article;

import com.uta.cse.team7.newscenter.models.FeedItem;


public interface IArticlePresenter {
    void attemptArticleLoading(String url);

    void archiveArticle(FeedItem feedItem, String article);

    void removeArticle(FeedItem feedItem);
}
