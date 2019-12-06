package com.uta.cse.team7.newscenter.curatedfeeds;

import com.uta.cse.team7.newscenter.models.SourceItem;

import java.util.List;

public interface OnCuratedFeedsRetrievedListener {
    void onSuccess(List<SourceItem> sourceItems);

    void onFailure(String message);
}
