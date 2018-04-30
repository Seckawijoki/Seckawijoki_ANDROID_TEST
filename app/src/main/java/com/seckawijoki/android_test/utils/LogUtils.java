package com.seckawijoki.android_test.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/4 at 23:43.
 */

public class LogUtils {
  private static final String TAG = "LogUtils";
  private LogUtils(){

  }
  public static void logActivityTask(Context context){
    ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
    List<ActivityManager.RunningTaskInfo> runningTaskInfoList =  am.getRunningTasks(10);
    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTaskInfoList) {
      Log.d(TAG, "id: " + runningTaskInfo.id);
      Log.d(TAG,"description: " + runningTaskInfo.description);
      Log.d(TAG,"number of activities: " + runningTaskInfo.numActivities);
      Log.d(TAG,"topActivity: " + runningTaskInfo.topActivity);
      Log.d(TAG,"baseActivity: " + runningTaskInfo.baseActivity.toString());
    }
  }
}
