package com.nghiadev.mvppractice.data.network;

import com.nghiadev.mvppractice.data.network.model.ResponseData;

import retrofit2.Call;
import retrofit2.Retrofit;

public interface ApiHelper {

    ApiList getApiList();

    Call<ResponseData> login(String phoneNumber, String password);

}
