package com.seckawijoki.android_test.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seckawijoki.android_test.R;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/20 at 16:15.
 */

public class ADialog extends DialogFragment {
  private static final String TAG = "LifecycleDialog";

  public static ADialog newInstance() {
    Bundle args = new Bundle();
    ADialog fragment = new ADialog();
    fragment.setArguments(args);
    return fragment;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    Log.i(TAG, "onCreateDialog(): ");
    return super.onCreateDialog(savedInstanceState);
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    Log.i(TAG, "onAttach(): ");
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "onCreate(): ");
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    Log.i(TAG, "onCreateView(): ");
    return inflater.inflate(R.layout.a_dialog, container, false);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    Log.i(TAG, "onActivityCreated(): ");
  }

  @Override
  public void onStart() {
    super.onStart();
    Log.i(TAG, "onStart(): ");
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.i(TAG, "onResume(): ");
  }

  @Override
  public void onPause() {
    super.onPause();
    Log.i(TAG, "onPause(): ");
  }

  @Override
  public void onStop() {
    super.onStop();
    Log.i(TAG, "onStop(): ");
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    Log.i(TAG, "onDestroyView(): ");
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.i(TAG, "onDestroy(): ");
  }

  @Override
  public void onDetach() {
    super.onDetach();
    Log.i(TAG, "onDetach(): ");
  }
}
