package com.nghiadev.mvppractice;

import android.app.Application;

import com.nghiadev.mvppractice.data.DataManager;
import com.nghiadev.mvppractice.di.component.ApplicationComponent;
import com.nghiadev.mvppractice.di.component.DaggerApplicationComponent;
import com.nghiadev.mvppractice.di.module.ApplicationModule;

import javax.inject.Inject;

public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
