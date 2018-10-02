package com.kashyap.wallpapers.ui.ImageControlHolder;

import android.support.v4.app.FragmentManager;

import com.kashyap.wallpapers.R;

public class ImageContentPresenter implements ImageContentContract.Presenter {

    private final ImageContentContract.View mView;

    public ImageContentPresenter(ImageContentContract.View view) {
        this.mView = view;
    }

    @Override
    public void initPager(FragmentManager fragmentManager, int tabCount) {
        Pager mPager = new Pager(fragmentManager, tabCount);
        mPager.addFrag(mView.setCategoryFragment(), mView.getContext().getString(R.string.category_fragment_title));
        mPager.addFrag(mView.setHomeFragment(), mView.getContext().getString(R.string.home_fragment_title));
        mPager.addFrag(mView.setFavoriteFragment(), mView.getContext().getString(R.string.favorite_fragment_title));

        mView.setAdapter(mPager);
    }

}
