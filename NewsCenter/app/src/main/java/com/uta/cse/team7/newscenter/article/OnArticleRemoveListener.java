package com.uta.cse.team7.newscenter.article;


public interface OnArticleRemoveListener {
    void onArticleDeleted(String message);

    void onArticleDeletionFailed(String message);
}
