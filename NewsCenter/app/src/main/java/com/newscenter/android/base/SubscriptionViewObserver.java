package com.newscenter.android.base;

import android.view.View;

import com.newscenter.model.Subscription;

// TODO: 10/23/16 check this architecture (past data from view to presenter)
public interface SubscriptionViewObserver {
    void onItemClick(View view, Subscription data);
    boolean onItemLongClick(View view, Subscription data);
}
