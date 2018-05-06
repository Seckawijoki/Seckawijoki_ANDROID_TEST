package com.seckawijoki.android_test.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by seckawijoki on 18-5-5 at 上午10:20.
 */
public abstract class AbsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
    }
    public void startActivity(String intentAction){
        startActivity(new Intent(intentAction));
    }
    @LayoutRes
    public abstract int setLayout();
    protected abstract void initView();
}
