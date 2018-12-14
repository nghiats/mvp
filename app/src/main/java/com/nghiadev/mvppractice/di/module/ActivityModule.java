package com.nghiadev.mvppractice.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.nghiadev.mvppractice.di.ActivityContext;
import com.nghiadev.mvppractice.di.PerActivity;
import com.nghiadev.mvppractice.ui.main.MainMvpPresenter;
import com.nghiadev.mvppractice.ui.main.MainPresenter;
import com.nghiadev.mvppractice.ui.main.MainMvpView;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

}
