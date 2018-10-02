package com.kashyap.wallpapers.ui.ImageControlHolder.category;

import com.kashyap.wallpapers.R;
import com.kashyap.wallpapers.ui.BaseFragment;
import com.kashyap.wallpapers.ui.BasePresenter;

public class CategoryFragment extends BaseFragment implements CategoryContract.View {
    @Override
    public int layoutId() {
        return R.layout.fragment_category;
    }

    public static CategoryFragment getInstance() {
        return new CategoryFragment();
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }
}
