package com.seckawijoki.android_test.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.activity.DataBindingTestActivity;
import com.seckawijoki.android_test.databinding.DataBindingTestFragmentBinding;
import com.seckawijoki.android_test.javabean.DataBindingUser;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/29 at 23:59 under Windows-10 Professional.
 */
public class DataBindingTestFragment extends Fragment {
  private static final String TAG = "DataBindingTestFragment";
  private DataBindingTestFragmentBinding binding;

  public static DataBindingTestFragment newInstance() {
    Bundle args = new Bundle();
    DataBindingTestFragment fragment = new DataBindingTestFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    Log.i(TAG, "onCreateView(): ");
    binding = DataBindingUtil.inflate(inflater, R.layout.data_binding_test_fragment, container, false);
    //binding.setHint();
    return binding.getRoot();
  }

  @Override
  public void onResume() {
    Log.i(TAG, "onResume(): ");
    super.onResume();
  }

  public DataBindingTestFragment setUserInfo(DataBindingUser user){
    if ( binding != null ) {
      binding.setUserInfo(user);
    }
    return this;
  }
  public DataBindingTestFragment setUserPresenter(DataBindingTestActivity.DataBindingUserPresenter userPresenter){
    if ( binding != null ) {
      binding.setUserPresenter(userPresenter);
    }
    return this;
  }

}
