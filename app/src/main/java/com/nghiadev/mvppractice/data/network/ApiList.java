package com.nghiadev.mvppractice.data.network;

import com.nghiadev.mvppractice.data.network.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiList {
    @FormUrlEncoded
    @POST("/api/user/login")
    Call<ResponseData> loginNumber(
            @Field("phone") String phoneNumber,
            @Field("password") String password
    );
}
