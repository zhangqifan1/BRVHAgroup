package com.zqf.brvhagroup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        List<MySection> list = new ArrayList<>();
        list.add(new MySection(true,"Section0","image0"));
        list.add(new MySection(new Bean("Item" + 0, "haed" + 0)));
        list.add(new MySection(new Bean("Item" + 1, "haed" + 1)));
        list.add(new MySection(new Bean("Item" + 2, "haed" + 2)));
        list.add(new MySection(new Bean("Item" + 3, "haed" + 3)));
        list.add(new MySection(new Bean("Item" + 4, "haed" + 4)));
        list.add(new MySection(true,"Section1","image1"));
        list.add(new MySection(new Bean("Item" + 0, "haed" + 0)));
        list.add(new MySection(new Bean("Item" + 1, "haed" + 1)));
        list.add(new MySection(new Bean("Item" + 2, "haed" + 2)));
        list.add(new MySection(new Bean("Item" + 3, "haed" + 3)));
        list.add(new MySection(new Bean("Item" + 4, "haed" + 4)));
        list.add(new MySection(true,"Section2","image2"));
        list.add(new MySection(new Bean("Item" + 0, "haed" + 0)));
        list.add(new MySection(new Bean("Item" + 1, "haed" + 1)));
        list.add(new MySection(new Bean("Item" + 2, "haed" + 2)));
        list.add(new MySection(new Bean("Item" + 3, "haed" + 3)));
        list.add(new MySection(new Bean("Item" + 4, "haed" + 4)));



        SectionAdapter sectionAdapter = new SectionAdapter(R.layout.item, R.layout.head, list);
        recyclerview.setAdapter(sectionAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }
}

