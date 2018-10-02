package com.kashyap.wallpapers.domain.models;

import com.kashyap.wallpapers.utils.Constant;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Images extends RealmObject {

    @PrimaryKey
    private String mId = Constant.StringConstants.EMPTY;
    private String mFilePath = Constant.StringConstants.EMPTY;
    private boolean isFavorite = false;
    private int mCatId = 0;
    private String mCategoryName = Constant.StringConstants.EMPTY;


    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getFilePath() {
        return mFilePath;
    }

    public void setFilePath(String mFilePath) {
        this.mFilePath = mFilePath;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getCatId() {
        return mCatId;
    }

    public void setCatId(int mCatId) {
        this.mCatId = mCatId;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String mCategoryName) {
        this.mCategoryName = mCategoryName;
    }


}
