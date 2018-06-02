package com.seckawijoki.androidtest.service;

import com.seckawijoki.androidtest.base.AbsLifecycleService;

/**
 * Created by seckawijoki on 2018-05-11 at 11:19 under Ubuntu-16.04 LTS.
 */
public class LifecycleService extends AbsLifecycleService{
  private static final String TAG = "LifecycleService";
  @Override
  public String setTag() {
    return TAG;
  }
}
