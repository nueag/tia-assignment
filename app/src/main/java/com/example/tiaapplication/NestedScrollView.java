package com.example.tiaapplication;

import android.content.Intent;
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
            testDataSet.add(new User("친구" + i, "010-0000-000" + i));
        }
        //========================================================

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        CustomAdapter customAdapter = new CustomAdapter(testDataSet);

        customAdapter.setOnItemClickListener((v, position) -> {
            Intent intent = new Intent(getApplicationContext(), ChattingRoom.class);
            User user = customAdapter.getItem(position);
            intent.putExtra("name", user.getName());
            startActivity(intent);
        });

        recyclerView.setAdapter(customAdapter);
        recyclerView2.setAdapter(customAdapter);

    }
}
