package com.seckawijoki.android_test.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/4 at 23:25.
 */

public class WhetherIntentService extends IntentService {
  private static final String TAG = "WhetherIntentService";
  private static final String ACTION_MAIN = "com.perqin.myapplication.action.MAIN";

  public WhetherIntentService() {
    super("WhetherIntentService");
  }

  public static void startAction(Context context) {
    Intent intent = new Intent(context, WhetherIntentService.class);
    intent.setAction(ACTION_MAIN);
    context.startService(intent);
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    Log.i(TAG, "onHandleIntent: Thread ID = " + Thread.currentThread().getId());
  }
}
