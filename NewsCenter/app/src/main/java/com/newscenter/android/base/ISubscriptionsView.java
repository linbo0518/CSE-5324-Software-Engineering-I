package com.newscenter.android.base;

import android.content.Context;

import com.newscenter.android.view.main.Category;

import java.util.List;

public abstract class ISubscriptionsView extends MVPView {
    protected SubscriptionViewObserver mObserver;

    public ISubscriptionsView(Context context) {
        super(context);
    }

    public abstract void setDataSource(List<Category> categoryList);

    public void setObserver(SubscriptionViewObserver observer) {
        mObserver = observer;
    }
}
