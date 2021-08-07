package com.example.nmid_7.logic;

import androidx.lifecycle.MutableLiveData;


import com.example.nmid_7.logic.model.JsonRootBean;
import com.example.nmid_7.logic.network.MyApplicationNetwork;

public class Repository {

    public static MutableLiveData<JsonRootBean> getData(){
        return MyApplicationNetwork.getData();
    }
}
