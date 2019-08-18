package com.seckawijoki.androidtest.activity;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.base.AbsActivity;
import com.seckawijoki.androidtest.base.RecyclerButton;
import com.seckawijoki.androidtest.tool.ImplicitNativeHelper;
import com.seckawijoki.androidtest.tool.NativeHelper;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.IOException;

/**
 * Created by Seckawijoki on 2018/6/13 at 10:21 under Windows10 Professional.
 */
public class BuglyTestActivity extends AbsActivity implements RecyclerButton.OnRecyclerButtonClickListener {
  private static final String TAG = "BuglyTestActivity";
  private static final String[] TITLES = {
    "NullPointer",
    "ArrayIndexOutOfBound",
          "NativeException",
          "testForJava",
          "testForANR",
          "testForNative",
  };
  @Override
  public int setLayout() {
    return R.layout.bugly_test_activity;
  }

  @Override
  protected void initView() {
    RecyclerView rv = (RecyclerView) findViewById(R.id.rv_bugly_test);
    rv.setAdapter(new RecyclerButton.Builder(this)
    .setVertical(3).setOnRecyclerButtonClickListener(this).setRecyclerView(rv).setTitleRes(TITLES).build());
  }

  @Override
  public void onClick(int position) {
    switch ( position ){
      case 0:
        String s = null;
        Log.d(TAG, "onClick()\n: s = " + s.substring(0));
        break;
      case 1:
        int a[] = new int[5];
        Log.d(TAG, "onClick()\n: a[6] = " + a[6]);
        break;
      case 2:
        ImplicitNativeHelper.zeroDivision();
        break;
      case 3:
        CrashReport.testJavaCrash();
        break;
      case 4:
        CrashReport.testANRCrash();
        break;
      case 5:
        CrashReport.testNativeCrash();
        break;
    }
  }
}
