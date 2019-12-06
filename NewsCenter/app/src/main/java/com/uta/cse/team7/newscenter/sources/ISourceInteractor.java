package com.uta.cse.team7.newscenter.sources;

import com.uta.cse.team7.newscenter.models.SourceItem;

public interface ISourceInteractor {
    void addSourceToDb(OnSourceSavedListener onSourceSavedListener, SourceItem sourceItem);

    void getSourcesFromDb(OnSourcesLoadedListener onSourcesLoadedListener);

    void getSourceItemsFromDb(OnSourcesLoadedListener onSourcesLoadedListener);

    void editSourceItemInDb(OnSourcesModifyListener onSourcesModifyListener, SourceItem sourceItem, String sourceNameOld);

    void deleteSourceItemFromDb(OnSourcesModifyListener onSourcesModifyListener, SourceItem sourceItem);
}
