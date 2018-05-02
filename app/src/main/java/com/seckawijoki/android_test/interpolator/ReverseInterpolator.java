package com.seckawijoki.android_test.interpolator;

import android.animation.TimeInterpolator;

/**
 * Created by seckawijoki on 18-5-2 at 下午1:19.
 */
public class ReverseInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }
}
