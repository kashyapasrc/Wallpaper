package com.kashyap.wallpapers.ui.ImageControlHolder;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.kashyap.wallpapers.ui.BasePresenter;
import com.kashyap.wallpapers.ui.BaseView;

public interface ImageContentContract {
    interface View extends BaseView {
        Fragment setHomeFragment();

        Fragment setCategoryFragment();

        Fragment setFavoriteFragment();

        Context getContext();

        Activity getActivity();

        void setAdapter(Pager pager);

    }

    interface Presenter extends BasePresenter {
        void initPager(FragmentManager fragmentManager, int tabCount);
    }

    interface CallBacks {

    }
}
