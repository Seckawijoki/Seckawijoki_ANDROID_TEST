package com.seckawijoki.androidtest.listener;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.seckawijoki.androidtest.R;

/**
 * Created by 瑶琴频曲羽衣魂 on 2017/6/22.
 */

public class TouchForLargeningListener implements View.OnTouchListener {
  private static final String TAG = "android_test";
  private final static float startRatio = 1.0f, endRatio = 1.15f;
  private boolean isLargening;
  private float currentRatio;
  private ValueAnimator largenAnimator, diminishAnimator;
  private Animation largen, diminish;

  public TouchForLargeningListener(Context context) {
//    startRatio = Float.parseFloat(context.getResources().getString(R.string.from_x_y_touch_event));
//    endRatio = Float.parseFloat(context.getResources().getString(R.string.to_x_y_touch_event));
//    startRatio = context.getResources().getDimension(R.dimen.from_x_y_touch_event);
//    endRatio = context.getResources().getDimension(R.dimen.to_x_y_touch_event);
    currentRatio = startRatio;
    largen = AnimationUtils.loadAnimation(context, R.anim.anim_on_touch_largen);
    diminish = AnimationUtils.loadAnimation(context, R.anim.anim_on_touch_dminish);
    largen.setFillEnabled(true);
    diminish.setFillEnabled(true);

    largenAnimator = ValueAnimator.ofFloat(currentRatio, endRatio);
    diminishAnimator = ValueAnimator.ofFloat(currentRatio, startRatio);
  }

  @Override
  public boolean onTouch(final View v, final MotionEvent event) {
    if (v.getLeft() > event.getX()
            || event.getX() > v.getRight()
            || v.getTop() > event.getY()
            || event.getY() > v.getBottom())
      return false;
    Log.d(TAG, "v.getY() = " + v.getY());
    Log.d(TAG, "v.getScrollY() = " + v.getScrollY());
    Log.d(TAG, "v.getTranslationY() = " + v.getTranslationY());
    Log.d(TAG, "");
    switch (event.getAction()) {
      default:
        return false;
      case MotionEvent.ACTION_UP:
        Log.e(TAG, "ACTION_UP" + ((TextView)v).getText());
        v.startAnimation(diminish);
        break;
      case MotionEvent.ACTION_DOWN:
        Log.e(TAG, "ACTION_DOWN" + ((TextView)v).getText());
        v.startAnimation(largen);
        break;
      case MotionEvent.ACTION_CANCEL:
        Log.e(TAG, "ACTION_CANCEL" + ((TextView)v).getText());
        v.startAnimation(diminish);
        /*
        if (v.getLeft() <= event.getX()
      && event.getX() <= v.getRight()
      && v.getTop() <= event.getY()
      && event.getY() <= v.getBottom())
          v.startAnimation(diminish);
        */
        break;
    }
    return true;
/**
 largenAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
 private void startAnimation(View view, ValueAnimator animator){
 currentRatio = (float) animator.getAnimatedValue();
 view.setScaleX(currentRatio);
 view.setScaleY(currentRatio);
 }
 @Override public void onAnimationUpdate(ValueAnimator animation) {
 switch (event.getAction()){
 case MotionEvent.ACTION_DOWN:
 Log.e(TAG, "ACTION_DOWN");
 startAnimation(v, animation);
 isLargening = true;
 break;
 case MotionEvent.ACTION_CANCEL:
 Log.e(TAG, "ACTION_CANCEL");
 if (v.getLeft() > event.getX() || event.getX() > v.getRight()
 || v.getTop() > event.getY() || event.getY() > v.getBottom()) {
 v.startAnimation(largen);
 isLargening = true;
 } else {
 ;
 }
 break;
 }
 }
 });

 diminishAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
 private void startAnimation(View view, ValueAnimator animator){
 currentRatio = (float) animator.getAnimatedValue();
 view.setScaleX(currentRatio);
 view.setScaleY(currentRatio);
 }
 @Override public void onAnimationUpdate(ValueAnimator animation) {
 switch (event.getAction()){
 case MotionEvent.ACTION_UP:
 Log.e(TAG, "ACTION_UP");
 startAnimation(v, animation);
 isLargening = false;
 break;
 case MotionEvent.ACTION_CANCEL:
 Log.e(TAG, "ACTION_CANCEL");
 if (v.getLeft() <= event.getX() && event.getX() <= v.getRight()
 && v.getTop() <= event.getY() && event.getY() <= v.getBottom()) {
 startAnimation(v, animation);
 isLargening = false;
 }
 break;
 }
 }
 });

 if (!isLargening)largenAnimator.start();
 if (isLargening)diminishAnimator.start();
 */

  }
}
