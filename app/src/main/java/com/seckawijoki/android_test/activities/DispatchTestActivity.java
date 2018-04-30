package com.seckawijoki.android_test.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.seckawijoki.android_test.R;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/21 at 23:48.
 */

public class DispatchTestActivity extends Activity {
  private static final String TAG = "DispatchTestActivity";
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dispatch_test_activity);
  }

  public void onClickOne(View view) {
    Log.i(TAG, "onClickOne(): ");

  }

  public void onClickTwo(View view) {
    Log.i(TAG, "onClickTwo(): ");
  }

  public void onClickViewGroup(View view) {
    Log.i(TAG, "onClickViewGroup(): ");
  }
}
