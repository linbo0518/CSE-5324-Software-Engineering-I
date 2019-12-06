package com.uta.cse.team7.newscenter.archive;

import android.content.Context;

public interface IArchiveInteractor {
    void retrieveArchiveFromDb(OnArticleRetrievedListener onArticleRetrievedListener, Context context);
}
