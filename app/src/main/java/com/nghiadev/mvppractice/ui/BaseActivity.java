package com.nghiadev.mvppractice.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nghiadev.mvppractice.MvpApp;
import com.nghiadev.mvppractice.di.component.ActivityComponent;
import com.nghiadev.mvppractice.di.component.DaggerActivityComponent;
import com.nghiadev.mvppractice.di.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity implements MvpView, BaseFragment.Callback {

    private ActivityComponent activityComponent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((MvpApp)getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
        setUp();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    protected abstract void setUp();

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
