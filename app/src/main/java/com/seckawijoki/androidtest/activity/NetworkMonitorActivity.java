package com.seckawijoki.androidtest.activity;

import android.content.Intent;

import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.base.AbsActivity;

/**
 * Created by Seckawijoki on 2018/7/17 at 22:08 under Windows10 Professional.
 */
public class NetworkMonitorActivity extends AbsActivity {
  @Override
  public int setLayout() {
    return R.layout.network_monitor_activity;
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void initView() {
  }


  private void showWifiSettings(){
    Intent intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
    startActivity(intent);
  }



}
