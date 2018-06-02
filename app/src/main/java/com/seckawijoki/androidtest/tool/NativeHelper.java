package com.seckawijoki.androidtest.tool;

import android.util.Log;

/**
 * Created by Seckawijoki on 2018/6/1 at 16:21 under Windows10 Professional.
 */
public class NativeHelper {
  private static final String TAG = "NativeHelper";
  static {
    System.loadLibrary("native-lib");
  }
  public static void invokeNativeMethodFromApplication(){
//    Log.d(TAG, "invokeNativeMethodFromApplication()\n: getAppKey() = " + getAppKey());
    invokeJavaFromC();
  }
  private static native String getAppKey();
  private static native void invokeJavaFromC();
}
