package com.seckawijoki.androidtest.application;

import android.app.Application;
import android.content.Intent;
import android.os.StrictMode;
import android.util.Log;

import com.seckawijoki.androidtest.javabean.Apple;
import com.seckawijoki.androidtest.tool.FruitAnnotationTool;
import com.seckawijoki.androidtest.tool.ImplicitNativeHelper;
import com.seckawijoki.androidtest.tool.NativeHelper;
//import com.seckawijoki.jnilibrary.NativeCalculators;

import org.appplay.lib.NetworkMonitorService;
//import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/31 at 15:22 under Windows-10 Professional.
 */
public class SeckawijokiApplication extends Application {
  private static final String TAG = "SeckawijokiApplication";
  @Override
  public void onCreate() {
    super.onCreate();
//    Log.i(TAG, "CrashReport.initCrashReport()");
    //CrashReport.initCrashReport(getApplicationContext());
//    FruitAnnotationTool.getInfo(Apple.class);
    Log.i(TAG, "CrashReport::initCrashReport ");
    //True for test
    //    CrashReport.initCrashReport(getApplicationContext(), NativeHelper.getAppKey(), true);
//        CrashReport.initCrashReport(getApplicationContext());
//    NativeHelper.invokeNativeMethodFromApplication();
//    ImplicitNativeHelper.invokeNativeMethodFromApplication();
//    NativeCalculators.add(2,3);
    StrictMode.setThreadPolicy(
            new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectCustomSlowCalls()
                    .detectNetwork()
                    .penaltyLog()
                    .build()
    );
    StrictMode.setVmPolicy(
            new StrictMode.VmPolicy.Builder()
                    .detectActivityLeaks()
                    .detectLeakedClosableObjects()
                    .detectLeakedSqlLiteObjects()

                    .penaltyLog()
                    .build()
    );
    startService(new Intent(this, NetworkMonitorService.class));
  }
}
