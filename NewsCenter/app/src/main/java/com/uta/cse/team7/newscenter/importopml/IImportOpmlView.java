package com.uta.cse.team7.newscenter.importopml;

import com.uta.cse.team7.newscenter.models.SourceItem;

import java.util.List;

public interface IImportOpmlView {
    void opmlFeedsRetrieved(List<SourceItem> sourceItems);

    void opmlFeedsRetrievalFailed(String message);
}
