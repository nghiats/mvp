package com.nghiadev.mvppractice.di.component;

import com.nghiadev.mvppractice.di.PerActivity;
import com.nghiadev.mvppractice.di.module.ActivityModule;
import com.nghiadev.mvppractice.di.module.GsonModule;
import com.nghiadev.mvppractice.ui.main.MainActivity;

import dagger.Component;
import retrofit2.Retrofit;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
