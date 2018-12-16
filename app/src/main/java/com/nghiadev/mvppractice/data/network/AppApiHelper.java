package com.nghiadev.mvppractice.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nghiadev.mvppractice.BuildConfig;
import com.nghiadev.mvppractice.data.network.model.ResponseData;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.Credentials;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class AppApiHelper implements ApiHelper {
    private static final long TIME_OUT_IN_MILISEC = 30000;
    private ApiList listApi;

    @Inject
    public AppApiHelper(Retrofit retrofit) {
        listApi = retrofit.create(ApiList.class);
    }

    @Override
    public ApiList getApiList() {
        return listApi;
    }

    @Override
    public Single<ResponseData> login(final String phoneNumber, final String password) {
        return listApi.loginNumber(phoneNumber, password);
    }


}
