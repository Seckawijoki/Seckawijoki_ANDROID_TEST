package com.seckawijoki.android_test.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by seckawijoki on 18-5-3 at 上午10:45.
 */
public abstract class AbsLifecycleLogActivity extends AppCompatActivity {
  protected String TAG;

  public AbsLifecycleLogActivity() {
    TAG = setTag();
  }

  public abstract String setTag();
//后弦
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
//        TAG = setTag();
    Log.i(TAG, this + "onCreate(): ");
    super.onCreate(savedInstanceState);
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
//        TAG = setTag();
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
  public void onConfigurationChanged(Configuration newConfig) {
    Log.i(TAG, this + "onConfigurationChanged(): ");
    super.onConfigurationChanged(newConfig);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    Log.i(TAG, this + "onSaveInstanceState(): ");
    super.onSaveInstanceState(outState);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    Log.i(TAG, this + "onRestoreInstanceState(): ");
    super.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.i(TAG, this + "onActivityResult(): ");
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  public String toString() {
    return "@" + Integer.toHexString(hashCode()) + ".";
  }
}
