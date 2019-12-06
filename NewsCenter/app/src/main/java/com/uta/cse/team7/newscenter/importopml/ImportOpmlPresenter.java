package com.uta.cse.team7.newscenter.importopml;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.uta.cse.team7.newscenter.R;
import com.uta.cse.team7.newscenter.models.SourceItem;
import com.uta.cse.team7.newscenter.ui.activities.SettingsActivity;
import com.uta.cse.team7.newscenter.utils.NetworkConnectionUtil;
import com.uta.cse.team7.newscenter.utils.UrlUtil;

import java.io.File;
import java.util.List;

public class ImportOpmlPresenter implements IImportOpmlPresenter, OnOpmlImportListener {
    private static ImportOpmlInteractor sImportOmplInteractor;
    private static Context sContext;
    private static ImportOpmlPresenter sImportOmplPresenter;
    private IImportOpmlView mView;
    private EditText mETxtUrl;

    public ImportOpmlPresenter(IImportOpmlView mView, Context context) {
        this.mView = mView;
        sContext = context;
        sImportOmplInteractor = new ImportOpmlInteractor();
        sImportOmplPresenter = this;
    }

    public static void onFileSelected(File file) {
        Log.e("File", file.getAbsolutePath());
        sImportOmplInteractor.retrieveFeeds(sImportOmplPresenter, sContext, file);
    }

    public void attemptFeedsRetrievalFromOpml(boolean isUrl) {
        if (isUrl) {
            MaterialDialog urlDialog = new MaterialDialog.Builder(sContext)
                    .title(R.string.enter_url)
                    .customView(R.layout.dialog_ompl_url, true)
                    .positiveText(R.string.get_feeds)
                    .negativeText(R.string.cancel)
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(MaterialDialog dialog, DialogAction which) {
                            String url = mETxtUrl.getText().toString();
                            //String url="http://scripting.com/feeds/top100.opml";
                            if (NetworkConnectionUtil.isNetworkAvailable(sContext)) {
                                if (url.isEmpty()) {
                                    mView.opmlFeedsRetrievalFailed("网址不能为空");
                                } else if (!url.matches(UrlUtil.REGEX_URL)) {
                                    mView.opmlFeedsRetrievalFailed("无效的网址");
                                } else {
                                    sImportOmplInteractor.retrieveFeed(ImportOpmlPresenter.this, sContext, url);
                                }
                            } else {
                                NetworkConnectionUtil.showNoNetworkDialog(sContext);
                            }
                        }
                    }).build();
            mETxtUrl = (EditText) urlDialog.getView().findViewById(R.id.edit_text_url);
            urlDialog.show();
        } else {
            SettingsActivity.sFileChooserDialog.show((AppCompatActivity) sContext);
        }
    }

    @Override
    public void onSuccess(List<SourceItem> sourceItems) {
        mView.opmlFeedsRetrieved(sourceItems);
    }

    @Override
    public void onFailure(String message) {
        mView.opmlFeedsRetrievalFailed(message);
    }
}
