package com.seckawijoki.androidtest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/4 at 23:22.
 */

public class WhetherReceiver extends BroadcastReceiver {
  private static final String TAG = "WhetherReceiver";
  @Override
  public void onReceive(Context context, Intent intent) {
    Log.i(TAG, "onReceive: Thread ID = " + Thread.currentThread().getId());
  }
}