package com.seckawijoki.androidtest.fragment;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.base.RecyclerButton;
import com.seckawijoki.androidtest.binder.MyTestingBinder;
import com.seckawijoki.androidtest.service.LifecycleService;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/11 at 16:09.
 */

public class MyServiceTestFragment extends Fragment implements RecyclerButton.OnRecyclerButtonClickListener {
  private static final String TAG = "MyServiceTestFragment";
  private Activity activity;
  private ServiceConnection serviceConnection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
      Log.d(TAG, "onServiceConnected(): name = " + name);
      MyTestingBinder binder = (MyTestingBinder) service;
      binder.TestingMethod();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
      Log.d(TAG, "onServiceDisconnected(): name = " + name);
    }
  };
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
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    Log.d(TAG, "MainActivity thread id is " + Thread.currentThread().getId());
    new RecyclerButton.Builder(getActivity())
            .setVertical()
            .setRecyclerView(view.findViewById(R.id.rv_operate_service))
            .setTitleRes(R.array.array_my_service_test_operate_service)
            .setOnRecyclerButtonClickListener(this)
            .build();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    activity = getActivity();
  }

  @Override
  public void onDetach() {
    super.onDetach();
  }

  @Override
  public void onClick(int position) {
    try {
      Intent intent = new Intent(activity, LifecycleService.class);
      switch (position) {
        case 0:
          activity.startService(intent);
          break;
        case 1:
          activity.stopService(intent);
          break;
        case 2:
          activity.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
          break;
        case 3:
          activity.unbindService(serviceConnection);
          break;
      }
    }catch ( Exception e ){
      Log.e(TAG, "onClick(): ", e);
    }
  }
}