package com.smallfish.qiongyou.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smallfish.qiongyou.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        loadData();

    }

    /**
     * 初始化数据
     */
    public void loadData() {

    }

    /**
     * 初始化视图
     */
    public void initView() {

    }
}
