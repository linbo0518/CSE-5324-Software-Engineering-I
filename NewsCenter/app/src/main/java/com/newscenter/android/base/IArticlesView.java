package com.newscenter.android.base;

import android.content.Context;

import com.newscenter.model.Article;

import java.util.List;

public abstract class IArticlesView extends MVPView {
    protected ArticleViewObserver mObserver;

    public IArticlesView(Context context) {
        super(context);
    }

    public abstract void setDataSource(List<Article> articleList);

    public void setObserver(ArticleViewObserver observer) {
        mObserver = observer;
    }
}
