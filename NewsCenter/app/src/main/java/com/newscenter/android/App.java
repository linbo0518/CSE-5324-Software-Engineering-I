package com.newscenter.android;

import android.app.Application;

import com.newscenter.android.util.ImageLoaderManager;
import com.newscenter.common.LogUtil;
import com.newscenter.android.util.StatManager;
import com.newscenter.common.SPManager;
import com.newscenter.common.ThreadManager;
import com.newscenter.domain.AssertManager;
import com.newscenter.domain.DBManager;
import com.newscenter.domain.inoreader.InoreaderManager;
import com.newscenter.domain.model.AccountModel;
import com.newscenter.domain.net.VolleySingleton;

import me.team7.feeder.BuildConfig;
import me.team7.feeder.R;

/**
 * @description:
 * @author: Match
 * @date: 7/22/16
 */
// Mark : use account as collection
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LogUtil.enable(BuildConfig.DEBUG);
        LogUtil.d("App Init");

        // Need to init first start ******************

        ThreadManager.init();
        VolleySingleton.init(this);

        SPManager.init(this);

        DBManager.init(this);

        StatManager.init(this);

        ImageLoaderManager.init(this);

        AssertManager.setEnabled(BuildConfig.DEBUG);

        InoreaderManager.getInstance().init(BuildConfig.INOREADER_CLIENT_SECRET);

        // Need to init first end ******************

        AccountModel.setDefaultAccountName(getResources().getString(R.string.default_account_name));
    }
}
