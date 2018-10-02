package com.kashyap.wallpapers.ui.ImageControlHolder.favorite;

import com.kashyap.wallpapers.ui.ImageControlHolder.category.CategoryContract;

public class FavoritePresenter implements FavoriteContract.Presenter {

    private final FavoriteContract.View mView;

    public FavoritePresenter(FavoriteContract.View view) {
        this.mView = view;
    }

}
