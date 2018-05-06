package com.seckawijoki.android_test.activity;

import com.seckawijoki.android_test.base.AbsLifecycleLogActivity;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/20 at 16:12.
 */

public class AnActivity extends AbsLifecycleLogActivity {
  private static final String TAG = "LifecycleActivity-B";

  @Override
  public String setTag() {
    return TAG;
  }
}
