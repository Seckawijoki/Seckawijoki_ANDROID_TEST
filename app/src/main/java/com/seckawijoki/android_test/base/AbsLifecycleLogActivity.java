package com.seckawijoki.android_test.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.seckawijoki.android_test.tool.LaunchModeTestActivitiesTool;

/**
 * Created by seckawijoki on 18-5-3 at 上午10:45.
 */
public abstract class AbsLifecycleLogActivity extends Activity {
    private String TAG;
    public AbsLifecycleLogActivity(){
        TAG = getTAG();
    }

    public abstract String getTAG();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TAG = getTAG();
        Log.i(TAG, this + "onCreate(): ");
        super.onCreate(savedInstanceState);
        new LaunchModeTestActivitiesTool(this);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, this + "onStart(): ");
        super.onStart();
    }

    @Override
    protected void onNewIntent(Intent newIntent) {
        Log.i(TAG, this + "onNewIntent(): ");
        super.onNewIntent(newIntent);
        Intent oldIntent = getIntent();
        setIntent(newIntent);
    }


    @Override
    protected void onRestart() {
        Log.i(TAG, this + "onRestart(): ");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, this + "onResume(): ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, this + "onPause(): ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, this + "onStop(): ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, this + "onDestroy(): ");
        super.onDestroy();
    }

    @Override
    public String toString() {
        return "@" + Integer.toHexString(hashCode())+".";
    }
}
