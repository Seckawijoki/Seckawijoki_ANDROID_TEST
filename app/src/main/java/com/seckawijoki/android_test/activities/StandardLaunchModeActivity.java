package com.seckawijoki.android_test.activities;
/**
 * Created by seckawijoki on 18-5-2 at 下午10:32.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.seckawijoki.android_test.tools.LaunchModeTestActivitiesTool;

public class StandardLaunchModeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new LaunchModeTestActivitiesTool(this);
    }

}