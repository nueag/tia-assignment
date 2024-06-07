package com.example.tiaapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class EditTextView extends AppCompatActivity {
    private boolean isPasswordVisible;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text);

        ImageButton close_btn = (ImageButton)findViewById(R.id.close_btn);
        close_btn.setOnClickListener(v -> finish());

        SignUpBox phoneNumberInput = findViewById(R.id.phone_number_box);
        EditText phonEditText = phoneNumberInput.getEditText();
        Button visibleButton = findViewById(R.id.visible_button);
        visibleButton.setVisibility(View.INVISIBLE);

        isPasswordVisible = false;
        phoneNumberInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("test", "input : " + s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0) {
                    findViewById(R.id.visible_button).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.visible_button).setVisibility(View.INVISIBLE);
                }
            }
        });

        visibleButton.setOnClickListener(v -> {
            if (isPasswordVisible) {
                phonEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                phonEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                visibleButton.setBackground(getResources().getDrawable(R.drawable.visible));
                isPasswordVisible = false;
            } else {
                phonEditText.setTransformationMethod(null);
                phonEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                visibleButton.setBackground(getResources().getDrawable(R.drawable.invisible));
                isPasswordVisible = true;
            }
            phonEditText.setSelection(phoneNumberInput.getEditText().getText().length());
        });

    }

    //keyBoard focus out
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }

        return super.dispatchTouchEvent( event );

    }

}
