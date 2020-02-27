package com.example.splalisrecy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends AppCompatActivity {
    private final int THREAT_SHOT=5;
    private boolean isLoading=false;
    private RecyclerView recyclerView;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView =(RecyclerView)findViewById(R.id.recycleid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //set adapter for recycle
        recyclerView.setAdapter(new RecycleAdapter());
        ((RecycleAdapter)recyclerView.getAdapter()).setListData(list);

        //set scroll event to load more data
        final LinearLayoutManager layoutManager=(LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
        if (!isLoading && layoutManager.getItemCount()-THREAT_SHOT==layoutManager.findLastVisibleItemPosition()){
            //call function loadmore
            loadmoredata();

                }
            }
        });
    }

    //init data
    public void initFirstData(){
        list = new ArrayList<>();
        for (int i =0; i<20;i++){
            list.add(i);
        }
    }
    //init load more function
    public void loadmoredata(){
        for (int i =0; i<10;i++){
            list.add(i);
        }
        recyclerView.getAdapter().notifyDataSetChanged();
}}
