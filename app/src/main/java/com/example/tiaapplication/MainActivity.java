package com.example.tiaapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;


public class MainActivity extends AppCompatActivity {

    private int gray;
    private int black;
    private int white;
    private int main;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //titleBar 삭제
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        gray = ContextCompat.getColor(this, R.color.gray);
        black = ContextCompat.getColor(this, R.color.black);
        white = ContextCompat.getColor(this, R.color.white);
        main = ContextCompat.getColor(this, R.color.main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.main_text);
                Button btn = findViewById(R.id.button);

                setColor(textView, btn);
            }
        });
        ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R.id.main_layout);
        mainLayout.setOnClickListener(v -> {
            TextView textView = findViewById(R.id.main_text);
            Button btn = findViewById(R.id.button);
            textView.setText("클릭 이벤트");
            btn.setTextColor(black);
            btn.setBackgroundColor(gray);
        });
    }
    private void setColor(TextView textView, Button btn) {
        if(textView.getText().equals("클릭 이벤트")) {
            textView.setText("Color : main");
            btn.setBackgroundColor(main);
            btn.setTextColor(white);
        } else if(textView.getText().equals("Color : main")) {
            textView.setText("Color : gray");
            btn.setBackgroundColor(gray);
            btn.setTextColor(black);
        } else {
            textView.setText("Color : main");
            btn.setBackgroundColor(black);
            btn.setTextColor(white);
        }
    }
}
