package com.example.nmid_7.logic.network;



import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceCreator {
    static final String BASE_URL = "https://www.wanandroid.com/";

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static  <T> T createService(Class<T> tClass) {
        return retrofit.create(tClass);
    }

}
