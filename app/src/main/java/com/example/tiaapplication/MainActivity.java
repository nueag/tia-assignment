package com.example.tiaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    private int gray;
    private int black;
    private int white;
    private int main;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        gray = ContextCompat.getColor(this, R.color.gray);
        black = ContextCompat.getColor(this, R.color.black);
        white = ContextCompat.getColor(this, R.color.white);
        main = ContextCompat.getColor(this, R.color.main);

        Button button = (Button)findViewById(R.id.button);
        Button changeViewButton = (Button) findViewById(R.id.change_view_button);
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

        //change view button
        changeViewButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), EditTextView.class);
            startActivity(intent);
            finish();
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
