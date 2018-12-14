package com.nghiadev.mvppractice.di.module;

import com.google.gson.Gson;
import com.nghiadev.mvppractice.BuildConfig;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module (includes = GsonModule.class)
public class RetrofitModule {

    @Provides
    public Retrofit provideRetrofit(Gson gson, OkHttpClient.Builder client, HttpLoggingInterceptor logging) {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.connectTimeout(BuildConfig.TIME_OUT_IN_MILISEC, TimeUnit.SECONDS);
        client.readTimeout(BuildConfig.TIME_OUT_IN_MILISEC, TimeUnit.SECONDS);
        client.addInterceptor(logging);
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    public OkHttpClient.Builder provideHttpClient() {
        return new OkHttpClient.Builder();
    }

    @Provides
    public HttpLoggingInterceptor provideLogging() {
        return new HttpLoggingInterceptor();
    }
}
