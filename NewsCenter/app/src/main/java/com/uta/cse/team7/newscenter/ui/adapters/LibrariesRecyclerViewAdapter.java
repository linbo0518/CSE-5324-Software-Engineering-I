package com.uta.cse.team7.newscenter.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uta.cse.team7.newscenter.R;
import com.uta.cse.team7.newscenter.models.LibraryItem;
import com.uta.cse.team7.newscenter.models.SettingsPreferences;
import com.uta.cse.team7.newscenter.utils.WebsiteIntentUtil;

import java.util.List;

public class LibrariesRecyclerViewAdapter extends RecyclerView.Adapter<LibrariesRecyclerViewAdapter.LibrariesViewHolder> {
    private Context mContext;
    private List<LibraryItem> mLibraryItems;

    public LibrariesRecyclerViewAdapter(Context mContext, List<LibraryItem> mLibraryItems) {
        this.mContext = mContext;
        this.mLibraryItems = mLibraryItems;
    }

    @Override
    public LibrariesRecyclerViewAdapter.LibrariesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_item, parent, false);
        LibrariesViewHolder librariesViewHolder = new LibrariesViewHolder(view);
        return librariesViewHolder;
    }

    @Override
    public void onBindViewHolder(LibrariesRecyclerViewAdapter.LibrariesViewHolder holder, int position) {
        holder.mTxtLibraryTitle.setText(mLibraryItems.get(position).getName());
        holder.mTxtLibraryCreator.setText(mLibraryItems.get(position).getCreator());
        holder.mTxtLibraryDesc.setText(mLibraryItems.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return mLibraryItems.size();
    }

    public class LibrariesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTxtLibraryTitle, mTxtLibraryCreator, mTxtLibraryDesc;

        public LibrariesViewHolder(View itemView) {
            super(itemView);
            mTxtLibraryTitle = (TextView) itemView.findViewById(R.id.text_view_library_title);
            mTxtLibraryCreator = (TextView) itemView.findViewById(R.id.text_view_library_creator);
            mTxtLibraryDesc = (TextView) itemView.findViewById(R.id.text_view_library_desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (SettingsPreferences.IN_APP_BROWSER) {
                new WebsiteIntentUtil(mContext).loadCustomChromeTabs(mLibraryItems.get(getAdapterPosition()).getLink());
            } else {
                new WebsiteIntentUtil(mContext).loadNormalBrowser(mLibraryItems.get(getAdapterPosition()).getLink());
            }
        }
    }
}
