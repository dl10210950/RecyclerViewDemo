package com.duanlian.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<String> list;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 99; i < 199; i++) {
            list.add("" + i);
        }

    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new MyAdapter(this, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void change(View view) {
        switch (view.getId()) {
            case R.id.listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                Toast.makeText(MainActivity.this, "ListView效果", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                Toast.makeText(MainActivity.this, "GridView效果", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hor_gridview:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                Toast.makeText(MainActivity.this, "横向GridView效果", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
