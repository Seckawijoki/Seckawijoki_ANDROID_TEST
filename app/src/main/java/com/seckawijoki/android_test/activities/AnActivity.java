package com.seckawijoki.android_test.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.seckawijoki.android_test.R;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/20 at 16:12.
 */

public class AnActivity extends Activity {
  private static final String TAG = "LifecycleActivity-B";
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "onCreate(): ");
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.i(TAG, "onStart(): ");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.i(TAG, "onResume(): ");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.i(TAG, "onPause(): ");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.i(TAG, "onStop(): ");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.i(TAG, "onDestroy(): ");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.i(TAG, "onRestart(): ");
  }

}
