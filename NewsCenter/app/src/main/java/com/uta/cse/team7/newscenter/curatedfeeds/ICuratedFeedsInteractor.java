package com.uta.cse.team7.newscenter.curatedfeeds;

import android.content.Context;


public interface ICuratedFeedsInteractor {
    void fetchCuratedFeedsFromServer(OnCuratedFeedsRetrievedListener onCuratedFeedsRetrievedListener, Context context);
}
