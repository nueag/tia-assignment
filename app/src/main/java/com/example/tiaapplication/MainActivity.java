package com.example.tiaapplication;

import android.os.Bundle;
import android.view.WindowInsetsController;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //titleBar 삭제
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //상태바 색깔 변경

    }
}
