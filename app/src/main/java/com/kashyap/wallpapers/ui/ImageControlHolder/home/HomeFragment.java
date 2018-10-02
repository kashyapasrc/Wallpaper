package com.kashyap.wallpapers.ui.ImageControlHolder.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.kashyap.wallpapers.R;
import com.kashyap.wallpapers.domain.models.Images;
import com.kashyap.wallpapers.ui.BaseFragment;
import com.kashyap.wallpapers.ui.BasePresenter;

import butterknife.BindView;
import io.realm.RealmResults;

public class HomeFragment extends BaseFragment implements HomeContract.View {


    private static HomeFragment instance;
    private HomePresenter mPresenter;
    private RealmResults<Images> mImages = null;
    private HomeAdapter mHomeAdapter;

    @BindView(R.id.layout_recyclerview_mat_mat_recyclerview_images)
    RecyclerView mRecyclerView;

    public static HomeFragment getInstance() {
        if (instance == null)
            instance = new HomeFragment();
        return instance;
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.mPresenter = (HomePresenter) presenter;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mPresenter != null) {
            mHomeAdapter = new HomeAdapter(getContext(), mImages);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            mRecyclerView.setAdapter(mHomeAdapter);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
            mPresenter.fetchImagesFromRealm();

        }
    }

    @Override
    public RealmResults<Images> getImagesFromRealm() {
        return mBaseRealm.where(Images.class).findAll();
    }

    @Override
    public void setImages(RealmResults<Images> images) {
        this.mImages = images;
        mHomeAdapter.setNewList(this.mImages);
    }

    @Override
    public void notifyDataSetChanged() {
        mHomeAdapter.notifyDataSetChanged();
    }
}
