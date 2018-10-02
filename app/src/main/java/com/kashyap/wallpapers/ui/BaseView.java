package com.kashyap.wallpapers.ui;


public interface BaseView<Presenter extends BasePresenter> {

    void setPresenter(Presenter presenter);


}