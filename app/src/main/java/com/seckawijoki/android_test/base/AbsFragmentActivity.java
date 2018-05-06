package com.seckawijoki.android_test.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by seckawijoki on 18-5-5 at 下午8:10.
 */
public abstract class AbsFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        Class c = setFragmentClass();

        Fragment fragment = getSupportFragmentManager().findFragmentById(setFragmentId());

    }

    public abstract Class setFragmentClass();
    @IdRes
    public abstract int setFragmentId();
    @LayoutRes
    public abstract int setLayout();
}
