package com.seckawijoki.android_test.fragment;

import android.os.Bundle;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.base.AbsLifecycleLogFragment;

/**
 * Created by seckawijoki on 18-5-5 at 下午9:38.
 */
public class LaunchModeFragment extends AbsLifecycleLogFragment {
  public static LaunchModeFragment newInstance() {

    Bundle args = new Bundle();

    LaunchModeFragment fragment = new LaunchModeFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public String setTag() {
    return LaunchModeFragment.class.getSimpleName();
  }

  @Override
  public int setLayout() {
    return R.layout.lifecycle_fragment;
  }

  @Override
  public void initView() {
  }
}
