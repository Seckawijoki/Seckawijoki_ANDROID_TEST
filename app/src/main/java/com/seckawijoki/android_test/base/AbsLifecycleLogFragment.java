package com.seckawijoki.android_test.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by seckawijoki on 18-5-5 at 下午9:30.
 */
public abstract class AbsLifecycleLogFragment extends Fragment {
  private String TAG;
  public AbsLifecycleLogFragment(){
    TAG = setTag();
  }
  public abstract String setTag();
  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    Log.i(TAG, this + "onCreate(): ");
    super.onCreate(savedInstanceState);
  }
  @Override
  public void onAttach(Context context) {
    Log.i(TAG, this + "onAttach(): ");
    super.onAttach(context);
  }

  @LayoutRes public abstract int setLayout();
  public abstract void initView();

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    Log.i(TAG, this + "onCreateView(): ");
    return inflater.inflate(setLayout(), container, false);
  }


  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    Log.i(TAG, this + "onActivityCreated(): ");
    super.onActivityCreated(savedInstanceState);
    initView();
  }

  @Override
  public void onStart() {
    Log.i(TAG, this + "onStart(): ");
    super.onStart();
  }

  @Override
  public void onResume() {
    Log.i(TAG, this + "onResume(): ");
    super.onResume();
  }

  @Override
  public void onPause() {
    Log.i(TAG, this + "onPause(): ");
    super.onPause();
  }

  @Override
  public void onStop() {
    Log.i(TAG, this + "onStop(): ");
    super.onStop();
  }

  @Override
  public void onDestroy() {
    Log.i(TAG, this + "onDestroy(): ");
    super.onDestroy();
  }

  @Override
  public void onDestroyView() {
    Log.i(TAG, this + "onDestroyView(): ");
    super.onDestroyView();
  }

  @Override
  public void onDetach() {
    Log.i(TAG, this + "onDetach(): ");
    super.onDetach();
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.i(TAG, this + "onActivityResult(): ");
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    Log.i(TAG, this + "onSaveInstanceState(): ");
    super.onSaveInstanceState(outState);
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    Log.i(TAG, this + "onConfigurationChanged(): ");
    super.onConfigurationChanged(newConfig);
  }

  @Override
  public void onHiddenChanged(boolean hidden) {
    Log.d(TAG, this + "onHiddenChanged(): hidden = " + hidden);
    super.onHiddenChanged(hidden);
  }

  @Override
  public String toString() {
    return "@" + hashCode() + ".";
  }
}
