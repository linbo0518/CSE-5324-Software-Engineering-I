package com.uta.cse.team7.newscenter.importopml;

import com.uta.cse.team7.newscenter.models.SourceItem;

import java.util.List;

public interface OnOpmlImportListener {
    void onSuccess(List<SourceItem> sourceItems);

    void onFailure(String message);
}
