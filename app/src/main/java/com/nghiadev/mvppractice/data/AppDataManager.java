package com.nghiadev.mvppractice.data;

import com.nghiadev.mvppractice.data.network.ApiHelper;
import com.nghiadev.mvppractice.data.network.ApiList;
import com.nghiadev.mvppractice.data.network.model.ResponseData;

import javax.inject.Inject;

import retrofit2.Call;

public class AppDataManager implements DataManager{
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(ApiHelper mApiHelper) {
        this.mApiHelper = mApiHelper;
    }


    @Override
    public ApiList getApiList() {
        return mApiHelper.getApiList();
    }

    @Override
    public Call<ResponseData> login(String phoneNumber, String password) {
        return mApiHelper.login(phoneNumber, password);
    }
}
