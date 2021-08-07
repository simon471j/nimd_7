package com.example.nmid_7.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nmid_7.logic.Repository;
import com.example.nmid_7.logic.model.JsonRootBean;

import retrofit2.adapter.rxjava2.Result;

public class MainActivityViewModel extends ViewModel {
        private MutableLiveData<JsonRootBean> mutableLiveData;

        public MainActivityViewModel() {
                mutableLiveData = Repository.getData();
        }

        public MutableLiveData<JsonRootBean> getMutableLiveData() {
                return mutableLiveData;
        }

        public void refreshData(){
               mutableLiveData=Repository.getData();
        }
}
