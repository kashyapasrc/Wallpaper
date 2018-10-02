package com.kashyap.wallpapers.ui.ImageControlHolder.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kashyap.wallpapers.R;
import com.kashyap.wallpapers.domain.models.Images;

import io.realm.RealmResults;

public class HomeAdapter extends RecyclerView.Adapter {


    private final Context mContext;
    private RealmResults<Images> mList;

    HomeAdapter(Context context, RealmResults<Images> list) {
        this.mContext = context;
        this.mList = list;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout_home_adapter, viewGroup, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((HomeViewHolder) viewHolder).onBind(mList.get(i), i);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void setNewList(RealmResults<Images> mImages) {
        this.mList = mImages;
    }
}
