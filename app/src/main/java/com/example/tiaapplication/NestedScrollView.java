package com.example.tiaapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NestedScrollView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nestedscrollview);

        List<User> testDataSet = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testDataSet.add(new User("친구" + i, "010-0000-000"+i));
        }
        //========================================================

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CustomAdapter customAdapter = new CustomAdapter(testDataSet);
        recyclerView.setAdapter(customAdapter);
    }
}
