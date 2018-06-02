package com.seckawijoki.androidtest.tool;

import android.util.Log;

/**
 * Created by Seckawijoki on 2018/6/2 at 11:29 under Windows10 Professional.
 */
public class InvokedJava {
  private static final String TAG = "InvokedJava";
  public void javaMethod(){
    Log.i(TAG, "javaMethod(): ");
  }
  public static void javaStaticMethod(){
    Log.i(TAG, "javaStaticMethod(): ");
  }
}
