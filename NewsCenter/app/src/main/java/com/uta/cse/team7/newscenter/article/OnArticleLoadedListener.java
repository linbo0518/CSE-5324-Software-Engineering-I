package com.uta.cse.team7.newscenter.article;


public interface OnArticleLoadedListener {
    void onSuccess(String message, String articleBody);

    void onFailure(String message);
}
