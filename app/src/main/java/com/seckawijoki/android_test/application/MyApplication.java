package com.seckawijoki.android_test.application;

import android.app.Application;
import android.util.Log;

import com.seckawijoki.android_test.javabean.Apple;
import com.seckawijoki.android_test.tool.FruitAnnotationTool;
import com.seckawijoki.android_test.tool.NativeHelper;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/31 at 15:22 under Windows-10 Professional.
 */
public class MyApplication extends Application {
  private static final String TAG = "MyApplication";
  @Override
  public void onCreate() {
    super.onCreate();
    FruitAnnotationTool.getInfo(Apple.class);
    Log.d(TAG, "onCreate()\n: " + NativeHelper.getAppKey());
  }
}
