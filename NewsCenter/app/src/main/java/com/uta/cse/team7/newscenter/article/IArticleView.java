package com.uta.cse.team7.newscenter.article;


public interface IArticleView {
    void onArticleLoaded(String article);

    void onArticleFailedToLoad(String message);

    void onArticleSaved(String message);

    void onArticleSavingFailed(String message);

    void onArticleRemoved(String message);

    void onArticleRemovalFailed(String message);
}
