package com.uta.cse.team7.newscenter.ui.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Toast;

import com.uta.cse.team7.newscenter.R;
import com.uta.cse.team7.newscenter.curatedfeeds.CuratedFeedsPresenter;
import com.uta.cse.team7.newscenter.curatedfeeds.ICuratedFeedsView;
import com.uta.cse.team7.newscenter.models.SourceItem;

import java.util.List;
import java.util.Set;

public class CustomCheckBoxListPreferenceDialog extends MultiSelectListPreference implements ICuratedFeedsView, Preference.OnPreferenceClickListener {
    private CuratedFeedsPresenter mCuratedFeedsPresenter;

    public CustomCheckBoxListPreferenceDialog(Context context, AttributeSet attrs) {
        super(context, attrs);

        setOnPreferenceClickListener(this);
        if (mCuratedFeedsPresenter == null) {
            mCuratedFeedsPresenter = new CuratedFeedsPresenter(this);
        }

        mCuratedFeedsPresenter.attemptCuratedFeedsLoading(getContext());
    }

    @Override
    public void onFeedsLoaded(List<SourceItem> sourceItems) {
        Toast.makeText(getContext(), "SourceItem: " + sourceItems.size(), Toast.LENGTH_SHORT).show();

        CharSequence[] sources = new CharSequence[sourceItems.size()];
        for (int i = 0; i < sourceItems.size(); i++) {
            sources[i] = sourceItems.get(i).getSourceName();
            Log.e("Source " + i, String.valueOf(sources[i]));
        }

        setEntries(sources);
        setEntryValues(sources);
    }

    @Override
    public void onFeedsLoadingFailure(String message) {
        Toast.makeText(getContext(), "Error:\n" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        return false;
    }

    @Override
    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        String curatedFeedsKey = getContext().getResources().getString(R.string.perf_curated_feeds_import_key);
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        Set<String> selections = sharedPrefs.getStringSet(curatedFeedsKey, null);
        for (String selectedVal : selections) {
            Log.e("Selected Values", selectedVal);
        }
        return super.getOnPreferenceChangeListener();
    }
}
