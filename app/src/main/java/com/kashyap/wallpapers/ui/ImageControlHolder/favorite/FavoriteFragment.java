package com.kashyap.wallpapers.ui.ImageControlHolder.favorite;

import com.kashyap.wallpapers.R;
import com.kashyap.wallpapers.ui.BaseFragment;
import com.kashyap.wallpapers.ui.BasePresenter;

public class FavoriteFragment extends BaseFragment implements FavoriteContract.View{
    private FavoritePresenter mPresenter;

    @Override
    public int layoutId() {
        return R.layout.fragment_favorite;
    }

    public static FavoriteFragment getInstance() {
        return new FavoriteFragment();
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.mPresenter = (FavoritePresenter) presenter;
    }
}
