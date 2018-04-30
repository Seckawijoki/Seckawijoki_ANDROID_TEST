package com.seckawijoki.android_test.activities;
/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/4 at 23:13.
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.constants.ReceiverActions;
import com.seckawijoki.android_test.services.WhetherIntentService;

public class WhetherInUiThreadActivity extends AppCompatActivity {
  private static final String TAG = "WhetherInUiActivity";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.whether_in_ui_thread_activity);
    Log.i(TAG, "onCreate: Thread ID = " + Thread.currentThread().getId());
    WhetherIntentService.startAction(WhetherInUiThreadActivity.this);
    sendBroadcast(new Intent(ReceiverActions.WHETHER_IN_UI_THREAD));
    getContentResolver().query(
            Uri.parse("content://com.seckawijoki.android_test.content_provider/main"),
            null, null, null, null
    );
    /*
    new Thread(new Runnable() {
      @Override
      public void run() {
        WhetherIntentService.startAction(WhetherInUiThreadActivity.this);
        sendBroadcast(new Intent(ReceiverActions.WHETHER_IN_UI_THREAD));
        getContentResolver().query(
                Uri.parse("content://com.seckawijoki.android_test.content_provider/main"),
                null, null, null, null
        );
      }
    }).start();
    */
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return true;
  }
}