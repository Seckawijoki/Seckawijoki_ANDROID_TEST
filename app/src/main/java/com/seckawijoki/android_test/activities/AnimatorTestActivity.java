package com.seckawijoki.android_test.activities;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.evaluator.CharEvaluator;
import com.seckawijoki.android_test.views.MyTestView;

/**
 * Created by seckawijoki on 18-5-2 at 上午10:18.
 */
public class AnimatorTestActivity extends Activity {
    private static final String TAG = "AnimatorTestActivity";
    private int colorPrimary;
    private MyTestView animated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animator_test_activity);
        colorPrimary = ContextCompat.getColor(this, R.color.colorPrimary);
        animated = findViewById(R.id.btn_animated);
    }

    public void ofInt(View v) {
        ValueAnimator translationAnimator = ValueAnimator.ofInt(0, 600);
        translationAnimator.setDuration(2000);
//        translationAnimator.setInterpolator(new MyInterpolator());
//        translationAnimator.setInterpolator(new ReverseInterpolator());
//        translationAnimator.setEvaluator(new MyEvaluator());
        translationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
//                Log.d(TAG, "onAnimationUpdate: " + currentValue);
                animated.layout(currentValue, currentValue, currentValue + animated.getWidth(), currentValue + animated.getHeight());
            }
        });
        translationAnimator.start();
    }

    public void argbEvaluator(View v) {
        ValueAnimator backgroundColorAnimator = ValueAnimator.ofInt(colorPrimary, 0xffffff00, 0xff0000ff, colorPrimary);
        backgroundColorAnimator.setEvaluator(new ArgbEvaluator());
        backgroundColorAnimator.setDuration(3000);

        backgroundColorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                animated.setBackgroundColor(curValue);

            }
        });

        backgroundColorAnimator.start();
    }

    public void ofObject(View v) {
        ValueAnimator letterAnimator = ValueAnimator.ofObject(new CharEvaluator(), 'A', 'Z');
        letterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char currentValue = (char) animation.getAnimatedValue();
                animated.setText(String.valueOf(currentValue));
            }
        });
        letterAnimator.setDuration(5200);
        letterAnimator.start();
    }

    public void objectAnimator(View v) {
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(animated, "alpha", 0, 1, 0, 1);
        alphaAnimator.setDuration(2000);
        alphaAnimator.start();
    }

    public void propertyValuesHolder(View v) {
        PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("Rotation", 40f,
                -40f, 20f, -20f, 10f - 10f, 5, -5, 0);
        PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt("BackgroundColor",
                colorPrimary, 0xffffffff, 0xff000000, 0xffffffff, colorPrimary);
        PropertyValuesHolder transitionXHolder = PropertyValuesHolder.ofFloat("TranslationX", 300, 0, 150, 0, 50);
        PropertyValuesHolder integerTextHolder = PropertyValuesHolder.ofObject("IntegerText",
                new IntEvaluator(), 0, 100);
        ObjectAnimator mixAnimator = ObjectAnimator.ofPropertyValuesHolder(animated, rotationHolder, colorHolder, transitionXHolder, integerTextHolder);
        mixAnimator.setDuration(3000);
        mixAnimator.start();
    }

    public void keyframe(View v) {
        Keyframe kf0 = Keyframe.ofFloat(0, 0);
        Keyframe kf1 = Keyframe.ofFloat(0.25f, 600);
//        kf1.setInterpolator(new OvershootInterpolator());
        Keyframe kf2 = Keyframe.ofFloat(0.5f, 0);
        Keyframe kf3 = Keyframe.ofFloat(0.75f, 300);
        Keyframe kf4 = Keyframe.ofFloat(1, 50);
        PropertyValuesHolder translationYHolder = PropertyValuesHolder.ofKeyframe("TranslationY", kf0, kf1, kf2, kf3, kf4);
        ObjectAnimator translationYAnimator = ObjectAnimator.ofPropertyValuesHolder(animated, translationYHolder);
        translationYAnimator.setDuration(3000);
        translationYAnimator.start();
    }

    public void keyframeOfObject(View v) {
        Keyframe kf0 = Keyframe.ofObject(0, 0);
        Keyframe kf1 = Keyframe.ofObject(0.12f, 230);
        Keyframe kf2 = Keyframe.ofObject(1, 90);
        PropertyValuesHolder integerTextHolder = PropertyValuesHolder.ofKeyframe("IntegerText",
                kf0, kf1, kf2);
        integerTextHolder.setEvaluator(new IntEvaluator());
        ObjectAnimator integerTextAnimator = ObjectAnimator.ofPropertyValuesHolder(animated, integerTextHolder);
        integerTextAnimator.setDuration(12000);
        integerTextAnimator.start();
    }

    public void playTogether(View v) {
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(animated, "translationY", 0, 600, 0);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(animated, "alpha", 1, 0, 1);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(animated, "scaleX", 1, 1.2f, 1);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(animated, "scaleY", 1, 1.2f, 1);
        ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofInt(animated,
                "backgroundColor", colorPrimary, 0xffffffff, colorPrimary);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translationYAnimator, alphaAnimator, scaleXAnimator,
                scaleYAnimator, backgroundColorAnimator);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }

    public void playBuilder(View v) {
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(animated, "translationY", 0, 600, 0);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(animated, "alpha", 1, 0, 1);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(animated, "scaleX", 1, 1.2f, 1);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(animated, "scaleY", 1, 1.2f, 1);
        ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofInt(animated,
                "backgroundColor", colorPrimary, 0xffffffff, colorPrimary);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimator).with(scaleYAnimator).after(translationYAnimator).before
                (alphaAnimator).before(backgroundColorAnimator);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }
}
