package com.nghiadev.mvppractice.di.component;

import android.app.Application;
import android.content.Context;

import com.nghiadev.mvppractice.MvpApp;
import com.nghiadev.mvppractice.di.ApplicationContext;
import com.nghiadev.mvppractice.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);
}
