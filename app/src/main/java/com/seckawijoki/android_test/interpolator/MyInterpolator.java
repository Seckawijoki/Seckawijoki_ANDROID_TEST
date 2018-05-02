package com.seckawijoki.android_test.interpolator;

import android.animation.TimeInterpolator;

/**
 * Created by seckawijoki on 18-5-2 at 下午1:17.
 */
public class MyInterpolator implements TimeInterpolator{

    @Override
    public float getInterpolation(float input) {
        return input;
    }
}
