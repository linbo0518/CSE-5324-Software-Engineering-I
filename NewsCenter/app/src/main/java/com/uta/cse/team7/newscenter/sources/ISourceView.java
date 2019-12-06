package com.uta.cse.team7.newscenter.sources;

import com.uta.cse.team7.newscenter.models.SourceItem;

import java.util.List;

public interface ISourceView {
    void dataSourceSaved(String message);

    void dataSourceSaveFailed(String message);

    void dataSourceLoaded(List<String> sourceNames);

    void dataSourceItemsLoaded(List<SourceItem> sourceItems);

    void dataSourceLoadingFailed(String message);

    void sourceItemModified(SourceItem sourceItem, String oldName);

    void sourceItemModificationFailed(String message);

    void sourceItemDeleted(SourceItem sourceItem);

    void sourceItemDeletionFailed(String message);
}
