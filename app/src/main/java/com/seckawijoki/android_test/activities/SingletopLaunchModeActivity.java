package com.seckawijoki.android_test.activities;
/**
 * Created by seckawijoki on 18-5-2 at 下午10:32.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.tools.LaunchModeTestActivitiesTool;

public class SingletopLaunchModeActivity extends AppCompatActivity {
    private static final String TAG = "SingletopActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new LaunchModeTestActivitiesTool(this);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent(): ");
    }
}