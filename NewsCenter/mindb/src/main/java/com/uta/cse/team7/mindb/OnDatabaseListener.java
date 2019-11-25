package com.uta.cse.team7.mindb;

import android.database.Cursor;

import java.util.List;

public interface OnDatabaseListener {
    void onSuccess(String message, List<String> values, Cursor cursor);

    void onFailure(String message);
}
