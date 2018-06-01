package com.seckawijoki.androidtest.fragment;

import android.os.Bundle;

import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.base.AbsLifecycleLogFragment;

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
