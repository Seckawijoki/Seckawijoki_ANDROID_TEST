package com.seckawijoki.androidtest.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by seckawijoki on 18-5-2 at 下午5:57.
 */
public class IntegerStringEvaluator implements TypeEvaluator<String> {
    @Override
    public String evaluate(float fraction, String startValue, String endValue) {
        int start = Integer.valueOf(startValue);
        int end = Integer.valueOf(endValue);
        int result = (int) (start + (end - start) * fraction);
        return result+"";
    }
}
