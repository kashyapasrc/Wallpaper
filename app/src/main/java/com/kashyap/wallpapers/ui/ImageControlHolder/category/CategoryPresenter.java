package com.kashyap.wallpapers.ui.ImageControlHolder.category;

public class CategoryPresenter implements CategoryContract.Presenter {

    private final CategoryContract.View mView;

    public CategoryPresenter(CategoryContract.View view) {
        this.mView = view;
    }
}
