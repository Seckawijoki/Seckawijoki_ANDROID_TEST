package com.seckawijoki.androidtest.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by seckawijoki on 18-5-2 at 下午2:15.
 */
public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt  = (int)startValue;
        int endInt = (int)endValue;
        int curInt = (int)(startInt + fraction *(endInt - startInt));
        char result = (char)curInt;
        return result;
    }
}
