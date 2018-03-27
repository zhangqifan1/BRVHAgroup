package com.zqf.apptree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        List<MultiItemEntity> list = new ArrayList<>();
        list.add(new Bean0("0000000000"));
        list.add(new Bean1("1111111111111"));
        list.add(new Bean2("22222222222222"));
        list.add(new Bean0("0000000000"));
        list.add(new Bean1("1111111111111"));
        list.add(new Bean0("0000000000"));
        list.add(new Bean1("1111111111111"));
        list.add(new Bean2("22222222222222"));
        list.add(new Bean0("0000000000"));

        ExpandableItemAdapter expandableItemAdapter = new ExpandableItemAdapter(list);
        recyclerview.setAdapter(expandableItemAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }
}
