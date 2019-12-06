package com.uta.cse.team7.newscenter.archive;

import com.uta.cse.team7.newscenter.models.FeedItem;

import java.util.List;

public interface IArchiveView {
    void onArchiveRetrieved(List<FeedItem> feedItems);

    void onArchiveRetrievalFailed(String message);
}
