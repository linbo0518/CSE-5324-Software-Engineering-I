package com.uta.cse.team7.newscenter.sources;

import com.uta.cse.team7.newscenter.models.SourceItem;

import java.util.List;

public interface OnSourcesLoadedListener {
    void onSourceLoaded(List<String> sourceNames);

    void onSourceItemsLoaded(List<SourceItem> sourceItems);

    void onSourceLoadingFailed(String message);
}
