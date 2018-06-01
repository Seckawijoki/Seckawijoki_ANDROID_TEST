package com.seckawijoki.androidtest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.fragment.MainFragment;
import com.seckawijoki.androidtest.util.ActivityUtil;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/8 at 19:53.
 */

public class MainActivity extends AppCompatActivity {
  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);
    MainFragment fragment =
            (MainFragment) getSupportFragmentManager().findFragmentById(R.id.layout_main_fragment);
    if (fragment == null){
      fragment = MainFragment.newInstance();
      ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.layout_main_fragment);
    }
  }
}
