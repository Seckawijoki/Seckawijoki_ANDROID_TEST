package com.seckawijoki.androidtest.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by seckawijoki on 2018-05-11 at 11:00 under Ubuntu-16.04 LTS.
 */
public abstract class AbsLifecycleService extends Service{
  private String TAG;
  public AbsLifecycleService(){
    TAG = setTag();
  }
  public abstract String setTag();
  @Override
  public void onCreate() {
    Log.i(TAG, "onCreate(): ");
    super.onCreate();
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.i(TAG, "onStartCommand(): ");
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public void onDestroy() {
    Log.i(TAG, "onDestroy(): ");
    super.onDestroy();
  }

  @Override
  public boolean onUnbind(Intent intent) {
    Log.i(TAG, "onUnbind(): ");
    return super.onUnbind(intent);
  }

  @Override
  public void onRebind(Intent intent) {
    Log.i(TAG, "onRebind(): ");
    super.onRebind(intent);
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    Log.i(TAG, "onBind(): ");
    return null;
  }
}
