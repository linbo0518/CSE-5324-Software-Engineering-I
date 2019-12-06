package com.uta.cse.team7.newscenter.curatedfeeds;

import com.uta.cse.team7.newscenter.models.SourceItem;

import java.util.List;


public interface ICuratedFeedsView {
    void onFeedsLoaded(List<SourceItem> sourceItems);

    void onFeedsLoadingFailure(String message);
}
