package com.nghiadev.mvppractice.ui;

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(Exception error);

}
