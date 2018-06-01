package com.seckawijoki.android_test.application;

import android.app.Application;

import com.seckawijoki.android_test.javabean.Apple;
import com.seckawijoki.android_test.tool.FruitAnnotationTool;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/31 at 15:22 under Windows-10 Professional.
 */
public class MyApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    FruitAnnotationTool.getInfo(Apple.class);
  }
}
