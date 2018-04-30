package com.seckawijoki.android_test.fragments;
/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/11 at 16:09.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seckawijoki.android_test.R;

public class MyServiceTestFragment extends Fragment {
  private static final String TAG = "MyServiceTestFragment";
  public static MyServiceTestFragment newInstance() {
    Bundle args = new Bundle();
    MyServiceTestFragment fragment = new MyServiceTestFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    setHasOptionsMenu(true);
    return inflater.inflate(R.layout.my_service_test_fragment, container, false);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    Log.d(TAG, "MainActivity thread id is " + Thread.currentThread().getId());

  }

  @Override
  public void onDetach() {
    super.onDetach();
  }

}