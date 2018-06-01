package com.seckawijoki.android_test.tool;

/**
 * Created by Seckawijoki on 2018/6/1 at 16:21 under Windows10 Professional.
 */
public class NativeHelper {
  static {
    System.loadLibrary("native-lib");
  }
  public static native String getAppKey();
}
