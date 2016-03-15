package com.example.stpan.listviewloadmoredemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyListView.IOnLoadMoreLister {
    private MyListView listView;
    private List<String> list = new ArrayList<>();
    private ListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        listView = (MyListView) findViewById(R.id.listView);
        listView.setOnLoadingMoreLister(this);
        initData();
    }

    private void initData(){
        for (int i = 0; i < 10; i++) {
            list.add("hello stpan "+i);
        }
        adapter = new ListViewAdapter(list,this);
        listView.setAdapter(adapter);
    }
    @Override
    public void loadingMore() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    list.add("hello stpan more "+i);
                }
                adapter.notifyDataSetChanged();
                listView.loadingComplete();
                if (list.size()>30){
                    listView.setIsEnd(true);
                }
            }
        }, 2000);
    }
}
