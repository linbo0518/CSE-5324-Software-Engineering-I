package com.uta.cse.team7.newscenter.sources;

import android.content.Context;

import com.uta.cse.team7.newscenter.models.SourceItem;

public interface ISourcePresenter {
    void addSource(SourceItem sourceItem);

    void getSources();

    void getSourceItems();

    void modifySources(Context context, SourceItem sourceItem);

    void deleteSource(SourceItem sourceItem);
}
