package com.seckawijoki.android_test.activity;
/**
 * Created by seckawijoki on 18-5-2 at 下午10:32.
 */

import android.os.Bundle;

import com.seckawijoki.android_test.base.AbsLifecycleLogActivity;

public class SingleInstanceLaunchModeActivity extends AbsLifecycleLogActivity {
    @Override
    public String getTAG() {
        return "SingleInstanceActivity";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}