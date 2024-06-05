package com.example.tiaapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SignUpBox extends ConstraintLayout {
    TextView text;
    EditText editText;

    public SignUpBox(@NonNull Context context) {
        super(context);
        initView();
    }

    public SignUpBox(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
        getAttrs(attrs);
    }

    private void initView() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.edit_box, this, false);

        addView(v);

        text = (TextView) findViewById(R.id.text_name);
        editText = (EditText) findViewById(R.id.text_name_hint);

    }
    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SignUpBox);
        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray) {
        String text_string = typedArray.getString(R.styleable.SignUpBox_text);
        text.setText(text_string);
        String text_hint_string = typedArray.getString(R.styleable.SignUpBox_hint);
        editText.setHint(text_hint_string);
        typedArray.recycle();

    }
    void setText(String text_string) {
        text.setText(text_string);

    }
    void setText(int text_resID) {
        text.setText(text_resID);
    }
    void setEditText(String hint_string) {
        editText.setText(hint_string);
    }
}
