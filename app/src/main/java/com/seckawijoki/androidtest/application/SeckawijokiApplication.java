package com.seckawijoki.androidtest.application;

import android.app.Application;
import android.content.Intent;

import org.appplay.lib.NetworkMonitorService;
import com.seckawijoki.androidtest.tool.ImplicitNativeHelper;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/31 at 15:22 under Windows-10 Professional.
 */
public class SeckawijokiApplication extends Application {
  private static final String TAG = "SeckawijokiApplication";
  @Override
  public void onCreate() {
    super.onCreate();
//    Log.i(TAG, "CrashReport.initCrashReport()");
    CrashReport.initCrashReport(getApplicationContext());
//    FruitAnnotationTool.getInfo(Apple.class);
    //True for test
    //    CrashReport.initCrashReport(getApplicationContext(), NativeHelper.getAppKey(), true);
//    NativeHelper.invokeNativeMethodFromApplication();
    ImplicitNativeHelper.invokeNativeMethodFromApplication();
//    NativeCalculators.add(2,3);
    startService(new Intent(this, NetworkMonitorService.class));
  }
}
