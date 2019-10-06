package com.newscenter.android.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.newscenter.android.util.AnimationHelper;
import com.newscenter.common.SPManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.team7.feeder.R;

import static com.newscenter.android.util.Constants.*;

public class SettingsActivity extends BaseSwipeActivity {

    @Bind(R.id.back_btn)
    ImageButton mBackButton;
    @Bind(R.id.title_txt)
    TextView mTitleTextView;

    @Bind(R.id.account_manage_img)
    ImageView mAccountManageImageView;
    @Bind(R.id.account_feedly_icon)
    ImageView mFeedlyIconImageView;
    @Bind(R.id.account_feedly_add)
    ImageView mFeedlyAddImageView;

    @Bind(R.id.font_size_img)
    ImageView mFontSizeImageView;
    @Bind(R.id.font_size_txt)
    TextView mFontSizeTextView;

    @Bind(R.id.wechat_img)
    ImageView mWechatImageView;
    @Bind(R.id.wechat_switch)
    SwitchCompat mWechatSwitch;
    @Bind(R.id.moment_img)
    ImageView mMomentImageView;
    @Bind(R.id.moment_switch)
    SwitchCompat mMomentSwitch;
    @Bind(R.id.weibo_img)
    ImageView mWeiboImageView;
    @Bind(R.id.weibo_switch)
    SwitchCompat mWeiboSwitch;
    @Bind(R.id.instapaper_img)
    ImageView mInstapaperImageView;
    @Bind(R.id.instapaper_switch)
    SwitchCompat mInstapaperSwitch;
    @Bind(R.id.google_plus_img)
    ImageView mGooglePlusImageView;
    @Bind(R.id.google_plus_switch)
    SwitchCompat mGooglePlusSwitch;
    @Bind(R.id.pocket_img)
    ImageView mPocketImageView;
    @Bind(R.id.pocket_switch)
    SwitchCompat mPocketSwitch;
    @Bind(R.id.evernote_img)
    ImageView mEvernoteImageView;
    @Bind(R.id.evernote_switch)
    SwitchCompat mEvernoteSwitch;
    @Bind(R.id.more_switch)
    SwitchCompat mMoreSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        initEnvironment();
        initView();
        setListener();
    }

    private void initEnvironment() {

    }

    private void initView() {

        mTitleTextView.setText(getTitle());

        mAccountManageImageView.setColorFilter(getResources().getColor(R.color.main_grey_normal));
        mFeedlyIconImageView.setColorFilter(getResources().getColor(R.color.main_grey_normal));
        mFeedlyAddImageView.setColorFilter(getResources().getColor(R.color.main_grey_normal));

        mFontSizeImageView.setColorFilter(getResources().getColor(R.color.main_grey_normal));
        setFontSizeText(SPManager.getInt(KEY_FONT_SIZE, FONT_SIZE_MEDIUM));

        mWechatSwitch.setChecked(SPManager.getBoolean(KEY_SWITCH_SHARE_WECHAT, true));
        mMomentSwitch.setChecked(SPManager.getBoolean(KEY_SWITCH_SHARE_MOMENT, true));
        mWeiboSwitch.setChecked(SPManager.getBoolean(KEY_SWITCH_SHARE_WEIBO, true));
        mInstapaperSwitch.setChecked(SPManager.getBoolean(KEY_SWITCH_SHARE_INSTAPAPER, true));
        mGooglePlusSwitch.setChecked(SPManager.getBoolean(KEY_SWITCH_SHARE_GOOGLE_PLUS, true));
        mPocketSwitch.setChecked(SPManager.getBoolean(KEY_SWITCH_SHARE_POCKET, true));
        mEvernoteSwitch.setChecked(SPManager.getBoolean(KEY_SWITCH_SHARE_EVERNOTE, true));
        mMoreSwitch.setChecked(SPManager.getBoolean(KEY_SWITCH_SHARE_MORE, true));
    }

    private void setListener() {
        mWechatSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPManager.setBoolean(KEY_SWITCH_SHARE_WECHAT, isChecked);
            }
        });
        mMomentSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPManager.setBoolean(KEY_SWITCH_SHARE_MOMENT, isChecked);
            }
        });
        mWeiboSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPManager.setBoolean(KEY_SWITCH_SHARE_WEIBO, isChecked);
            }
        });
        mInstapaperSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPManager.setBoolean(KEY_SWITCH_SHARE_INSTAPAPER, isChecked);
            }
        });
        mGooglePlusSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPManager.setBoolean(KEY_SWITCH_SHARE_GOOGLE_PLUS, isChecked);
            }
        });
        mPocketSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPManager.setBoolean(KEY_SWITCH_SHARE_POCKET, isChecked);
            }
        });
        mEvernoteSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPManager.setBoolean(KEY_SWITCH_SHARE_EVERNOTE, isChecked);
            }
        });
        mMoreSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPManager.setBoolean(KEY_SWITCH_SHARE_MORE, isChecked);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({
            R.id.back_btn,
            R.id.account_feedly_layout,
            R.id.font_size_layout,
            R.id.wechat_layout,
            R.id.moment_layout,
            R.id.weibo_layout,
            R.id.instapaper_layout,
            R.id.google_plus_layout,
            R.id.pocket_layout,
            R.id.evernote_layout,
            R.id.more_layout,
    })
    public void layoutOnClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                finish();
                break;
            case R.id.account_feedly_layout:
                startActivity(new Intent(SettingsActivity.this, AuthInoreaderActivity.class));
                break;
            case R.id.font_size_layout:
                showSingleChoice();
                break;
            case R.id.wechat_layout:
                mWechatSwitch.setChecked(!mWechatSwitch.isChecked());
                break;
            case R.id.moment_layout:
                mMomentSwitch.setChecked(!mMomentSwitch.isChecked());
                break;
            case R.id.weibo_layout:
                mWeiboSwitch.setChecked(!mWeiboSwitch.isChecked());
                break;
            case R.id.instapaper_layout:
                mInstapaperSwitch.setChecked(!mInstapaperSwitch.isChecked());
                break;
            case R.id.google_plus_layout:
                mGooglePlusSwitch.setChecked(!mGooglePlusSwitch.isChecked());
                break;
            case R.id.pocket_layout:
                mPocketSwitch.setChecked(!mPocketSwitch.isChecked());
                break;
            case R.id.evernote_layout:
                mEvernoteSwitch.setChecked(!mEvernoteSwitch.isChecked());
                break;
            case R.id.more_layout:
                mMoreSwitch.setChecked(!mMoreSwitch.isChecked());
                break;
        }
    }

    private void showSingleChoice() {
        // Index map to size value
        int currentSize = SPManager.getInt(KEY_FONT_SIZE, FONT_SIZE_MEDIUM);
        new MaterialDialog.Builder(this)
                .title(R.string.font)
                .items(R.array.font_size)
                .itemsCallbackSingleChoice(currentSize, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        SPManager.setInt(KEY_FONT_SIZE, which);
                        setFontSizeText(which);
                        dialog.dismiss();
                        return true; // allow selection
                    }
                })
                .show();
    }

    private void setFontSizeText(int fontSize) {
        switch (fontSize) {
            case FONT_SIZE_SMALL:
                mFontSizeTextView.setText(R.string.small);
                break;
            case FONT_SIZE_MEDIUM:
                mFontSizeTextView.setText(R.string.medium);
                break;
            case FONT_SIZE_BIG:
                mFontSizeTextView.setText(R.string.big);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AnimationHelper.overridePendingTransition(this);
    }
}
