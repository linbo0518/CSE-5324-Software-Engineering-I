package com.uta.cse.team7.newscenter.feeds;

import com.uta.cse.team7.newscenter.models.SourceItem;

import java.util.List;


public interface IFeedsLoaderInteractor {
    void loadFeedsFromDb(final OnFeedsLoadedListener onFeedsLoadedListener);

    void loadFeedsFromDbBySource(final OnFeedsLoadedListener onFeedsLoadedListener, String source);

    void loadFeedsAsync(OnFeedsLoadedListener onFeedsLoadedListener, List<SourceItem> sourceItems);
}
