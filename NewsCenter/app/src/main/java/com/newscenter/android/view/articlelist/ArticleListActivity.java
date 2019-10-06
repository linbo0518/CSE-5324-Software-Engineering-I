package com.newscenter.android.view.articlelist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.newscenter.android.base.IArticlesView;
import com.newscenter.android.base.MVPPresenter;
import com.newscenter.android.presenter.ArticlesPresenter;
import com.newscenter.android.util.AnimationHelper;
import com.newscenter.android.util.Constants;
import com.newscenter.android.util.StatManager;
import com.newscenter.android.view.BaseSwipeActivity;

import me.team7.feeder.R;

/**
 * @description:
 * @author: Match
 * @date: 10/25/16
 */

public class ArticleListActivity extends BaseSwipeActivity {
    private Toolbar mToolbar;
    private MVPPresenter mArticlePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getExtras() == null) {
            StatManager.statEvent(this, StatManager.EXCEPTION_EXTRAS_IS_NULL);
            finish();
            return;
        }

        final Long id = getIntent().getExtras().getLong(Constants.KEY_BUNDLE_SUBSCRIPTION_ID);
        String title = getIntent().getExtras().getString(Constants.KEY_BUNDLE_SUBSCRIPTION_TITLE);

        setContentView(R.layout.activity_article_list);

        // TODO: 4/12/17 move toolbar manager to presenter
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.inflateMenu(R.menu.menu_article_list);
        mToolbar.setTitle(title);
        mToolbar.setTitleTextColor(Color.WHITE);
//        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.action_change_layout:
//                        // TODO: 1/26/17 Support more
//                        if (SPManager.getInt(KEY_ARTICLE_LIST_LAYOUT, LAYOUT_STYLE_SIMPLE) == LAYOUT_STYLE_SIMPLE) {
//                            SPManager.setInt(KEY_ARTICLE_LIST_LAYOUT, LAYOUT_STYLE_RIGHT_IMAGE);
//                            Toast.makeText(ArticleListActivity.this, R.string.switch_to_image_layout, Toast.LENGTH_SHORT).show();
//                        } else if (SPManager.getInt(KEY_ARTICLE_LIST_LAYOUT, LAYOUT_STYLE_SIMPLE) == LAYOUT_STYLE_RIGHT_IMAGE) {
//                            SPManager.setInt(KEY_ARTICLE_LIST_LAYOUT, LAYOUT_STYLE_SIMPLE);
//                            Toast.makeText(ArticleListActivity.this, R.string.switch_to_text_layout, Toast.LENGTH_SHORT).show();
//                        }
//                        mArticlePresenter.onDataChanged();
//                        break;
//                    case R.id.action_mark_as_all_read:
//                        ArticleModel.getInstance().markAllRead(true, id);
//                        ThreadManager.postDelay(new Runnable() {
//                            @Override
//                            public void run() {
//                                finish();
//                                AnimationHelper.overridePendingTransition(ArticleListActivity.this);
//                            }
//                        }, 300);
//                        break;
//                }
//                return false;
//            }
//        });

        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        IArticlesView articlesView = new ArticlesView(this);
        LinearLayout.LayoutParams articlesViewLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
        container.addView(articlesView, articlesViewLp);

        mArticlePresenter = new ArticlesPresenter(this, articlesView, id);
        mArticlePresenter.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mArticlePresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mArticlePresenter.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AnimationHelper.overridePendingTransition(ArticleListActivity.this);
    }
}
