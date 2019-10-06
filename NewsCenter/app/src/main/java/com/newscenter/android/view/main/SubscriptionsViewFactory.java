package com.newscenter.android.view.main;

import android.content.Context;

import com.newscenter.android.base.ISubscriptionsView;

/**
 * @description:
 * @author: Match
 * @date: 12/11/16
 */

public class SubscriptionsViewFactory {

    public static ISubscriptionsView build(Context context) {
//        return new CategorySubscriptionListView(context);
        return new FlatSubscriptionListView(context);
    }
}
