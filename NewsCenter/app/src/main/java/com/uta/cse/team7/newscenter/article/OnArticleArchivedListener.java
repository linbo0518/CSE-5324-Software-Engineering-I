package com.uta.cse.team7.newscenter.article;


public interface OnArticleArchivedListener {
    void onArticleSaved(String message);

    void onArticleSavingFailed(String message);
}
