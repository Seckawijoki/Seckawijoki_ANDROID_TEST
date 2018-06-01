package com.seckawijoki.androidtest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.seckawijoki.androidtest.tool.LaunchModeTestTool;

/**
 * Created by seckawijoki on 18-5-5 at 下午9:55.
 */
public abstract class AbsLaunchModeActivity extends AbsLifecycleLogActivity{
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    new LaunchModeTestTool(this);
  }
}
