package com.nghiadev.mvppractice.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GsonUtils implements GsonHelper{

    Gson gson;

    @Inject
    public GsonUtils() {
        this.gson =  new GsonBuilder().setLenient().create();
    }


    @Override
    public Gson getGson() {
        return gson;
    }
}
