package com.kashyap.wallpapers.ui.ImageControlHolder.home;

import com.kashyap.wallpapers.domain.models.Images;
import com.kashyap.wallpapers.ui.BasePresenter;
import com.kashyap.wallpapers.ui.BaseView;

import io.realm.Realm;
import io.realm.RealmResults;

public interface HomeContract {


    interface View extends BaseView {

        RealmResults<Images> getImagesFromRealm();

        void setImages(RealmResults<Images> images);

        void notifyDataSetChanged();
    }

    interface Presenter extends BasePresenter {

        void fetchImagesFromRealm();
    }
}
