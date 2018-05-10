package com.seckawijoki.android_test.callback_pattern_mvp;

/**
 * Created by seckawijoki on 18-5-5 at 下午8:55.
 */
public interface BaseView<T extends BaseActionCallback> {
    void onPresenterInit();
    void onModelInit();
    void setActionCallback(T actionCallback);
}
