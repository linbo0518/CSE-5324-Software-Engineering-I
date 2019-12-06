package com.uta.cse.team7.newscenter.sources;

import com.uta.cse.team7.newscenter.models.SourceItem;

public interface OnSourcesModifyListener {
    void onSourceModified(SourceItem sourceItem, String oldName);

    void onSourceModifiedFailed(String message);

    void onSourceDeleted(SourceItem sourceItem);

    void onSourceDeletionFailed(String message);
}
