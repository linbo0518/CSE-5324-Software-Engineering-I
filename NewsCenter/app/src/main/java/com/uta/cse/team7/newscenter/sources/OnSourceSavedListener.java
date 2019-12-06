package com.uta.cse.team7.newscenter.sources;

public interface OnSourceSavedListener {
    void onSuccess(String message);

    void onFailure(String message);
}
