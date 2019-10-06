package com.newscenter.android.base;

import android.view.View;

import com.newscenter.model.Article;

import java.util.List;

public interface ArticleViewObserver {
    void onItemClick(View view, List<Article> dataList, int pos);
    boolean onItemLongClick(View view, List<Article> dataList, int pos);
}
