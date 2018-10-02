package com.kashyap.wallpapers.ui.ImageControlHolder.home;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.kashyap.wallpapers.R;
import com.kashyap.wallpapers.domain.models.Images;

import butterknife.BindView;
import butterknife.ButterKnife;

class HomeViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_layout_home_adapter_imageview)
    ImageView mImageViewWallPaper;

    HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBind(Images images, int position) {
        Uri uri = Uri.parse(images.getFilePath());
        if (uri != null)
            mImageViewWallPaper.setImageURI(uri);

    }

}
