package com.seckawijoki.android_test.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.constant.IntentActions;
import com.seckawijoki.android_test.dialog.ADialog;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/20 at 15:53.
 */

public class LifecycleActivity extends AppCompatActivity {
  private static final String TAG = "LifecycleActivity";

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "onCreate(): ");
    setContentView(R.layout.lifecycle_activity);
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.i(TAG, "onStart(): ");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.i(TAG, "onResume(): ");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.i(TAG, "onPause(): ");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.i(TAG, "onStop(): ");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.i(TAG, "onDestroy(): ");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.i(TAG, "onRestart(): ");
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    Log.i(TAG, "onConfigurationChanged(): ");
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.i(TAG, "onSaveInstanceState(): ");
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    Log.i(TAG, "onRestoreInstanceState(): ");
  }

  public void startAnActivity(View view) {
    startActivity(new Intent(IntentActions.AN_ACTIVITY));
  }

  public void openAnAlertDialog(View view) {
    AlertDialog alertDialog = new AlertDialog.Builder(this)
            .setTitle(R.string.lifecycle_open_an_alert_dialog)
            .setMessage(R.string.lifecycle_open_an_alert_dialog)
            .create();
    alertDialog.show();
  }

  public void openADialogFragment(View view) {
    ADialog aDialog = ADialog.newInstance();
    aDialog.show(getSupportFragmentManager(), null);
  }

  public void openADialogActivity(View view) {
    startActivity(new Intent(IntentActions.A_DIALOG_ACTIVITY));
  }
}
