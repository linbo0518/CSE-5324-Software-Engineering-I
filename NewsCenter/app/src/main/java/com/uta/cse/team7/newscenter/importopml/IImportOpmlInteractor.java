package com.uta.cse.team7.newscenter.importopml;

import android.content.Context;

import java.io.File;

public interface IImportOpmlInteractor {
    void retrieveFeed(OnOpmlImportListener onOpmlImportListener, Context context, String url);

    void retrieveFeeds(OnOpmlImportListener onOpmlImportListener, Context context, File file);
}
