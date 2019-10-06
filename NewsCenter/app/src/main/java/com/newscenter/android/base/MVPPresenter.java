package com.newscenter.android.base;

public interface MVPPresenter {
    void onCreate();

    void onStart();

    void onStop();

    void onDestroy();

    void onDataChanged();
}
