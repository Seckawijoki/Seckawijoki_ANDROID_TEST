package com.seckawijoki.android_test.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by seckawijoki on 18-5-2 at 下午1:43.
 */
public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int)(200 + startValue + (endValue - startValue) * fraction);
    }
}
