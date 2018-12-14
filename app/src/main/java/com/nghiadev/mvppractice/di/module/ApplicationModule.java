package com.nghiadev.mvppractice.di.module;

import android.app.Application;
import android.content.Context;

import com.nghiadev.mvppractice.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {GsonModule.class, RetrofitModule.class})
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

}
