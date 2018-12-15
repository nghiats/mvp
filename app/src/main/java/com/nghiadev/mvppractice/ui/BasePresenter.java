package com.nghiadev.mvppractice.ui;

import com.nghiadev.mvppractice.data.DataManager;

import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private DataManager dataManager;

    private V mvpView;

    @Inject
    public BasePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    private boolean isViewAttached() {
        return mvpView != null;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetach() {
        this.mvpView = null;
    }

    @Override
    public void handleApiError(Exception error) {

    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public V getMvpView() {
        return mvpView;
    }

    public void checkMvpViewIsAttached() {
        if (!isViewAttached()) throw new MvpNotAttachedException();
    }

    public static class MvpNotAttachedException extends RuntimeException {

        public MvpNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before requesting data to the Presenter");
        }
    }

}
