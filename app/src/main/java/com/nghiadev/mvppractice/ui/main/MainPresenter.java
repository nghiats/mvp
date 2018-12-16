package com.nghiadev.mvppractice.ui.main;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.nghiadev.mvppractice.data.DataManager;
import com.nghiadev.mvppractice.data.network.model.ResponseData;
import com.nghiadev.mvppractice.ui.BasePresenter;
import com.nghiadev.mvppractice.ui.MvpPresenter;

import java.util.Observable;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onButtonClicked() {
//        Call<ResponseData> request = getDataManager().getApiList().loginNumber("0932051902", "123456A");
//        request.enqueue(new Callback<ResponseData>() {
//            @Override
//            public void onResponse(@NonNull Call<ResponseData> call, @NonNull Response<ResponseData> response) {
//                getMvpView().showSuccessToast();
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<ResponseData> call, @NonNull Throwable t) {
//
//            }
//        });

        getDataManager().login("0932051902", "123456A")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<ResponseData>() {
                    @Override
                    public void onSuccess(ResponseData responseData) {
                        getMvpView().showSuccessToast();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }

    @Override
    public void handleApiError(Exception error) {

    }
}
