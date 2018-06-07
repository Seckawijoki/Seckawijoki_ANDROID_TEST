package com.seckawijoki.androidtest.tool;

import android.util.Log;

/**
 * Created by Seckawijoki on 2018/6/6 at 15:53 under Windows-10 Professional.
 */
public class ImplicitNativeHelper {
  private static final String TAG = "ImplicitNativeHelper";
  static {
    System.loadLibrary("implicitnativehelper-lib");
  }
  public static void invokeNativeMethodFromApplication(){
    Log.d(TAG, "getAppKey() = " + getAppKey());
//    Log.i(TAG, callFromMainLib());
    invokeJavaFromC();
  }
  private static native String getAppKey();
  private static native void invokeJavaFromC();
  private static native String callFromMainLib();
}
