package com.seckawijoki.android_test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.seckawijoki.android_test.R;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/25 at 20:24.
 */

public class AmapTestActivity extends Activity{
  private MapView mapView;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.amap_test_activity);
    mapView = (MapView) findViewById(R.id.map_amap_test);
    AMap aMap = mapView.getMap();
  }
}
