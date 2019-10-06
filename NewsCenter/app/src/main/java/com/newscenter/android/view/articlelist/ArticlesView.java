package com.newscenter.android.view.articlelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.newscenter.android.base.IArticlesView;
import com.newscenter.android.other.LinearLayoutManagerEx;
import com.newscenter.model.Article;

import java.util.List;

import me.team7.feeder.R;

/**
 * @description:
 * @author: Match
 * @date: 10/25/16
 */

public class ArticlesView extends IArticlesView {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ArticlesView(Context context) {
        super(context);
        mRecyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.view_recycler, this, false);

        mLayoutManager = new LinearLayoutManagerEx(context);
        mRecyclerView.setLayoutManager(mLayoutManager);
        addView(mRecyclerView);
    }

    @Override
    public void setDataSource(List<Article> articleList) {
        mAdapter = new ArticleAdapter(articleList, mObserver);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void notifyDataChanged() {
        super.notifyDataChanged();
        mAdapter.notifyDataSetChanged();
    }
}
