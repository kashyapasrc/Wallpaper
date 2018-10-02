package com.kashyap.wallpapers.ui.ImageControlHolder.home;

import com.kashyap.wallpapers.domain.models.Images;

import io.realm.RealmResults;

public class HomePresenter implements HomeContract.Presenter {

    private final HomeContract.View mView;

    public HomePresenter(HomeContract.View view) {
        this.mView = view;
    }


    @Override
    public void fetchImagesFromRealm() {
        RealmResults<Images> images = mView.getImagesFromRealm();
        mView.setImages(images);
        mView.notifyDataSetChanged();
    }
}
