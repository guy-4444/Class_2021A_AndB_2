package com.classy.class_2021a_andb_2;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_start);

        recyclerViewStatus = findViewById(R.id.recyclerViewStatus);
        updateList();
    }

    private void updateList() {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            data.add("Item " + i);
        }

        Adapter_Capsule itemArrayAdapter = new Adapter_Capsule(R.layout.list_item_status, data);
        recyclerViewStatus.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewStatus.setItemAnimator(new DefaultItemAnimator());
        recyclerViewStatus.setAdapter(itemArrayAdapter);
    }

}