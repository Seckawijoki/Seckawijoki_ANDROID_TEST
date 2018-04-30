package com.seckawijoki.android_test.listener;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.seckawijoki.android_test.R;

/**
 * Created by 瑶琴频曲羽衣魂 on 2017/6/22.
 */

public class CommonFocusChangeListener implements View.OnFocusChangeListener {
  private Animation largen, diminish;
  public CommonFocusChangeListener(Context context){
    largen = AnimationUtils.loadAnimation(context, R.anim.anim_on_touch_largen);
    diminish = AnimationUtils.loadAnimation(context, R.anim.anim_on_touch_dminish);
    largen.setFillEnabled(true);
    diminish.setFillEnabled(true);
  }
  @Override
  public void onFocusChange(View v, boolean hasFocus) {
    if (hasFocus)v.startAnimation(largen);
    else v.startAnimation(diminish);
  }
}
