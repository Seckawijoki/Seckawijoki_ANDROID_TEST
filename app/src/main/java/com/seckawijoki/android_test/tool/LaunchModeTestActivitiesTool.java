package com.seckawijoki.android_test.tool;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.activity.ADialogActivity;
import com.seckawijoki.android_test.activity.SingleInstanceLaunchModeActivity;
import com.seckawijoki.android_test.activity.SingleTaskLaunchModeActivity;
import com.seckawijoki.android_test.activity.SingletopLaunchModeActivity;
import com.seckawijoki.android_test.activity.StandardLaunchModeActivity;
import com.seckawijoki.android_test.base.AbsLifecycleLogActivity;

import java.util.List;

/**
 * Created by seckawijoki on 18-5-3 at 上午12:17.
 */
public final class LaunchModeTestActivitiesTool implements View.OnClickListener {
    private static final String TAG = "LaunchModeActivityTest";
    private final AbsLifecycleLogActivity activity;

    public LaunchModeTestActivitiesTool(AbsLifecycleLogActivity activity) {
        this.activity = activity;
//        logActivityManager();
        activity.setContentView(R.layout.launch_mode_activity);
        activity.findViewById(R.id.btn_start_standard_launch_mode_activity).setOnClickListener
                (this);
        activity.findViewById(R.id.btn_start_singletop_launch_mode_activity).setOnClickListener
                (this);
        activity.findViewById(R.id.btn_start_single_task_launch_mode_activity).setOnClickListener
                (this);
        activity.findViewById(R.id.btn_start_single_instance_launch_mode_activity)
                .setOnClickListener
                        (this);
        activity.findViewById(R.id.btn_start_dialog_activity).setOnClickListener(this);
        ((TextView) activity.findViewById(R.id.tv_launch_mode_activity)).setText(activity
                .toString()  + activity.getTAG());
    }

    private void logActivityManager() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityManager activityManager = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
            List<RunningTaskInfo> runningTaskInfoList = activityManager.getRunningTasks(5);
            List<AppTask> appTaskList = activityManager.getAppTasks();
            for (int i = 0; i < runningTaskInfoList.size(); i++) {
                RunningTaskInfo runningTaskInfo = runningTaskInfoList.get(i);
                Log.d(TAG, "logActivityManager(): runningTaskInfo = " + runningTaskInfo);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Class secondActivityClass = null;
        switch (v.getId()) {
            case R.id.btn_start_standard_launch_mode_activity:
                secondActivityClass = StandardLaunchModeActivity.class;
                break;
            case R.id.btn_start_singletop_launch_mode_activity:
                secondActivityClass = SingletopLaunchModeActivity.class;
                break;
            case R.id.btn_start_single_task_launch_mode_activity:
                secondActivityClass = SingleTaskLaunchModeActivity.class;
                break;
            case R.id.btn_start_single_instance_launch_mode_activity:
                secondActivityClass = SingleInstanceLaunchModeActivity.class;
                break;
            case R.id.btn_start_dialog_activity:
                secondActivityClass = ADialogActivity.class;
                break;
        }
        if (secondActivityClass != null) {
            Log.d(TAG, "onClick(): secondActivityClass = " + v.getId());
            activity.startActivity(new Intent(activity, secondActivityClass));
        }
    }
}
