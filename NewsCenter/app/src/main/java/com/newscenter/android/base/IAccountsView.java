package com.newscenter.android.base;

import android.content.Context;

import com.newscenter.model.Account;

import java.util.List;

public abstract class IAccountsView extends MVPView {
    protected AccountViewObserver mObserver;

    public IAccountsView(Context context) {
        super(context);
    }

    public abstract void setDataSource(List<Account> accountList);

    public void setObserver(AccountViewObserver observer) {
        mObserver = observer;
    }
}
