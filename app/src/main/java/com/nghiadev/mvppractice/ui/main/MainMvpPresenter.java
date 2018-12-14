package com.nghiadev.mvppractice.ui.main;

import com.nghiadev.mvppractice.ui.MvpPresenter;

public interface MainMvpPresenter <V extends MainMvpView> extends MvpPresenter<V> {
    void onButtonClicked();
}
