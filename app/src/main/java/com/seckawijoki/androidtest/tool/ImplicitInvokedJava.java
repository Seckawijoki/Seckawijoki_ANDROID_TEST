package com.seckawijoki.androidtest.tool;

import android.util.Log;

/**
 * Created by Seckawijoki on 2018/6/2 at 11:29 under Windows10 Professional.
 */
public class ImplicitInvokedJava {
  private static final String TAG = "ImplicitInvokedJava";
  public void javaMethod(){
    Log.i(TAG, "javaMethod(): ");
  }
  public static void javaStaticMethod(){
    Log.i(TAG, "javaStaticMethod(): ");
  }
  public static String getGreeting(){
    Log.i(TAG, "getGreeting(): ");
    return "Hello, JNI!";
  }
  public void sayHelloToJava(String greeting){
    Log.d(TAG, "sayHelloToJava()\n: greeting = " + greeting);
  }
}
