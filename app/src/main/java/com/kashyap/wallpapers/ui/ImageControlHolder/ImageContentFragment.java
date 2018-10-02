package com.kashyap.wallpapers.ui.ImageControlHolder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.kashyap.wallpapers.R;
import com.kashyap.wallpapers.ui.BaseFragment;
import com.kashyap.wallpapers.ui.BasePresenter;
import com.kashyap.wallpapers.ui.ImageControlHolder.category.CategoryContract;
import com.kashyap.wallpapers.ui.ImageControlHolder.category.CategoryFragment;
import com.kashyap.wallpapers.ui.ImageControlHolder.category.CategoryPresenter;
import com.kashyap.wallpapers.ui.ImageControlHolder.favorite.FavoriteContract;
import com.kashyap.wallpapers.ui.ImageControlHolder.favorite.FavoriteFragment;
import com.kashyap.wallpapers.ui.ImageControlHolder.favorite.FavoritePresenter;
import com.kashyap.wallpapers.ui.ImageControlHolder.home.HomeContract;
import com.kashyap.wallpapers.ui.ImageControlHolder.home.HomeFragment;
import com.kashyap.wallpapers.ui.ImageControlHolder.home.HomePresenter;
import com.kashyap.wallpapers.utils.Constant;

import butterknife.BindView;


public class ImageContentFragment extends BaseFragment implements ImageContentContract.View, ImageContentContract.CallBacks {


    private static ImageContentFragment instance;

    public static ImageContentFragment getInstance() {
        if (instance == null)
            instance = new ImageContentFragment();
        return instance;
    }

    @BindView(R.id.fragment_image_content_tablayout_title)
    TabLayout mTabLayout;
    @BindView(R.id.fragment_image_content_viewpager_fragment_pager)
    ViewPager mViewPager;
    private ImageContentPresenter mPresenter;


    @Override
    public int layoutId() {
        return R.layout.fragment_image_content;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.mPresenter = (ImageContentPresenter) presenter;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.initPager(getChildFragmentManager(), Constant.TAB_COUNT);


    }

    @Override
    public void setAdapter(Pager pager) {
        mViewPager.setAdapter(pager);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(Constant.TAB_COUNT);
        mViewPager.setCurrentItem(1);//set Home fragment as default.
    }

    @Override
    public Fragment setHomeFragment() {
        HomeFragment fragment = HomeFragment.getInstance();
        HomeContract.View view = (HomeContract.View) fragment;
        fragment.setPresenter(new HomePresenter(view));
        return fragment;
    }

    @Override
    public Fragment setCategoryFragment() {
        CategoryFragment fragment = CategoryFragment.getInstance();
        CategoryContract.View view = (CategoryContract.View) fragment;
        fragment.setPresenter(new CategoryPresenter(view));
        return fragment;
    }

    @Override
    public Fragment setFavoriteFragment() {
        FavoriteFragment fragment = FavoriteFragment.getInstance();
        FavoriteContract.View view = (FavoriteContract.View) fragment;
        fragment.setPresenter(new FavoritePresenter(view));
        return fragment;
    }
}
