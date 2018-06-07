package com.seckawijoki.androidtest.application;

import android.app.Application;
import android.util.Log;

import com.seckawijoki.androidtest.javabean.Apple;
import com.seckawijoki.androidtest.tool.FruitAnnotationTool;
import com.seckawijoki.androidtest.tool.ImplicitNativeHelper;
import com.seckawijoki.androidtest.tool.NativeHelper;
import com.seckawijoki.jnilibrary.NativeCalculators;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/31 at 15:22 under Windows-10 Professional.
 */
public class MyApplication extends Application {
  private static final String TAG = "MyApplication";
  @Override
  public void onCreate() {
    super.onCreate();
//    FruitAnnotationTool.getInfo(Apple.class);
//    NativeHelper.invokeNativeMethodFromApplication();
    ImplicitNativeHelper.invokeNativeMethodFromApplication();
    NativeCalculators.add(2,3);
  }
}
