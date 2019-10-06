package com.newscenter.android.view.articlelist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newscenter.android.base.ArticleViewObserver;
import com.newscenter.model.Article;

import java.util.List;

import me.team7.feeder.R;

/**
 * @description:
 * @author: Match
 * @date: 10/28/16
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private List<Article> mArticleList;
    private ArticleViewObserver mObserver;

    public ArticleAdapter(List<Article> list, ArticleViewObserver observer) {
        mArticleList = list;
        mObserver = observer;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, final int position) {
        if (mArticleList == null || position >= mArticleList.size()) {
            // TODO: 12/7/16 upload error state
            return;
        }
        holder.bind(mArticleList.get(position), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mObserver.onItemClick(v, mArticleList, position);
            }
        }, new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return mObserver.onItemLongClick(v, mArticleList, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }
}
