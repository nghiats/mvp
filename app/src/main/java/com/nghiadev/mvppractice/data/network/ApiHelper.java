package com.nghiadev.mvppractice.data.network;

import com.nghiadev.mvppractice.data.network.model.ResponseData;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Retrofit;

public interface ApiHelper {

    ApiList getApiList();

    Single<ResponseData> login(String phoneNumber, String password);

}
