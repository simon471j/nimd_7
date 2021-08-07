package com.example.nmid_7.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


import com.example.nmid_7.R;

import com.example.nmid_7.logic.model.Children;
import com.example.nmid_7.logic.model.JsonRootBean;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<Children> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MainActivityViewModel.class);
        ListView listView = findViewById(R.id.listView);
        viewModel.getMutableLiveData().observe(this, new Observer<JsonRootBean>() {
            @Override
            public void onChanged(JsonRootBean jsonRootBean) {
                Log.d("TAG", "onChanged: " + jsonRootBean.toString());
                initData(jsonRootBean);
                try {
                    listView.setAdapter(new SimpleTreeAdapter<Children>(listView,getApplicationContext(),data,0));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        viewModel.refreshData();
    }

    private void initData(JsonRootBean jsonRootBean) {
        this.data.clear();
        for (JsonRootBean.Data data : jsonRootBean.getData()) {
            for (Children child : data.getChildren()) {
                this.data.add(new Children(child.getId(),child.getName(),child.getParentChapterId()));
            }
            this.data.add(new Children(data.getId(), data.getName(),data.getParentChapterId()));
        }
    }
}