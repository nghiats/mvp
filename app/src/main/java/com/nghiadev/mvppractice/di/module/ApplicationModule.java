package com.nghiadev.mvppractice.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.nghiadev.mvppractice.data.AppDataManager;
import com.nghiadev.mvppractice.data.DataManager;
import com.nghiadev.mvppractice.data.network.ApiHelper;
import com.nghiadev.mvppractice.data.network.AppApiHelper;
import com.nghiadev.mvppractice.di.ApplicationContext;
import com.nghiadev.mvppractice.utils.GsonHelper;
import com.nghiadev.mvppractice.utils.GsonUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class})
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

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    GsonHelper provideGsonHelper(GsonUtils gson) {
        return gson;
    }


}
