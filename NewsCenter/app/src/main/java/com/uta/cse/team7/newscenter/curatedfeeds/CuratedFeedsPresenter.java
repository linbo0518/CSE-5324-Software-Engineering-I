package com.uta.cse.team7.newscenter.curatedfeeds;

import android.content.Context;

import com.uta.cse.team7.newscenter.models.SourceItem;

import java.util.List;

public class CuratedFeedsPresenter implements ICuratedFeedsPresenter, OnCuratedFeedsRetrievedListener {
    private ICuratedFeedsView mView;

    public CuratedFeedsPresenter(ICuratedFeedsView mView) {
        this.mView = mView;
    }

    public void attemptCuratedFeedsLoading(Context context) {
        CuratedFeedsInteractor curatedFeedsInteractor = new CuratedFeedsInteractor();
        curatedFeedsInteractor.fetchCuratedFeedsFromServer(this, context);
    }

    @Override
    public void onSuccess(List<SourceItem> sourceItems) {
        mView.onFeedsLoaded(sourceItems);
    }

    @Override
    public void onFailure(String message) {
        mView.onFeedsLoadingFailure(message);
    }
}
