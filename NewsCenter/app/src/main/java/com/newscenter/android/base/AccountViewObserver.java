package com.newscenter.android.base;

import android.view.View;

import com.newscenter.model.Account;

import java.util.List;

public interface AccountViewObserver {
    void onItemClick(View view, List<Account> dataList, int pos);
    boolean onItemLongClick(View view, List<Account> dataList, int pos);
}
