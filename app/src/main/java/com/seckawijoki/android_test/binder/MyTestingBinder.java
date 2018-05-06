package com.seckawijoki.android_test.binder;

import android.os.Binder;
import android.util.Log;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/11 at 16:07.
 */

public class MyTestingBinder extends Binder {
  private static final String TAG = "MyTestingBinder";
  public void TestingMethod(){
    Log.d(TAG, "TestingMethod()\n: true = " + true);
  }
}
