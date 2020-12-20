package com.example.javareview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.javareview.inject.InjectRes;
import com.example.javareview.inject.InjectUtil;

public class InjectActivity extends AppCompatActivity {

    private int mField1;
    private int mFiled2;

    @InjectRes(R.id.tv_content)
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inject_actiivty);
        InjectUtil.injectView(this);
        mTextView.setText("pdddd");
    }
}
