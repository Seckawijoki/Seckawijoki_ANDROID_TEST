package com.seckawijoki.androidtest.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.seckawijoki.androidtest.R;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/11 at 16:06.
 */

public class MyTestingService extends Service {
  public static final String TAG = "MyTestingService";
  @Override
  public void onCreate() {
    super.onCreate();
    Log.d(TAG, "MyService thread id is " + Thread.currentThread().getId());
    Log.d(TAG, "onCreate() executed");
    Notification notification = new Notification.Builder(this)
            .setContentTitle("Notification Title")
            .setContentText("Notification Content")
            .setSmallIcon(R.mipmap.ic_launcher)
            .build();
    NotificationManager notificationManager = (NotificationManager)
            getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(1, notification);
    new Thread(new Runnable() {
      @Override
      public void run() {
        // 开始执行后台任务
      }
    }).start();
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.d(TAG, "onStartCommand() executed");
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy() executed");
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
}
