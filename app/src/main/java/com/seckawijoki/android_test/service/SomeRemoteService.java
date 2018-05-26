package com.seckawijoki.android_test.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.seckawijoki.android_test.aidl.ISomeRemoteService;
import com.seckawijoki.android_test.base.AbsLifecycleService;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/11 at 17:23.
 */

public class SomeRemoteService extends AbsLifecycleService {
  private static final String TAG = "SomeRemoteService";
  private final ISomeRemoteService.Stub binder = new ISomeRemoteService.Stub(){

    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) {

    }

    @Override
    public String sendString(String s) {
      Log.d(TAG, "The string from remote activity: s = " + s);
      return "a string from remote service";
    }
  };
  @Override
  public String setTag() {
    return TAG;
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return binder;
  }
}
