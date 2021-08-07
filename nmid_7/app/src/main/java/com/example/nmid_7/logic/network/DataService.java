package com.example.nmid_7.logic.network;


import com.example.nmid_7.logic.model.JsonRootBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DataService {
    @GET("tree/json/")
    Observable<JsonRootBean> getData();
}
