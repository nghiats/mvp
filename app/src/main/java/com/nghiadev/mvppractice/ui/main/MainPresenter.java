package com.nghiadev.mvppractice.ui.main;

import android.widget.Toast;

import com.nghiadev.mvppractice.ui.BasePresenter;
import com.nghiadev.mvppractice.ui.MvpPresenter;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {


    @Override
    public void onAttach(V mvpView) {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void handleApiError(Exception error) {
        Toast.makeText(, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onButtonClicked() {

    }
}
