package com.example.nmid_7.logic.network;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;


import com.example.nmid_7.MyApp;
import com.example.nmid_7.logic.model.JsonRootBean;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyApplicationNetwork {
    private static MutableLiveData<JsonRootBean> jsonRootBean = new MutableLiveData<>();

    public static MutableLiveData<JsonRootBean> getData() {
        DataService dataService = ServiceCreator.createService(DataService.class);
        Observable<JsonRootBean> jsonRootBeanObservable = dataService.getData();
        if (jsonRootBeanObservable != null)
            jsonRootBeanObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<JsonRootBean>() {

                @Override
                public void onSubscribe(@org.jetbrains.annotations.NotNull Disposable d) {

                }


                @Override
                public void onNext(@org.jetbrains.annotations.NotNull JsonRootBean data) {
                    MyApplicationNetwork.jsonRootBean.setValue(data);
                    Log.d("TAG", "onNext: " + data.toString());
                }

                @Override
                public void onError(@org.jetbrains.annotations.NotNull Throwable e) {
                    Log.d("DataNetwork", "onError: " + e);
                }

                @Override
                public void onComplete() {

                }
            });
        Log.d("TAG", "getData: " + MyApplicationNetwork.jsonRootBean.toString());
        return MyApplicationNetwork.jsonRootBean;
    }
}
