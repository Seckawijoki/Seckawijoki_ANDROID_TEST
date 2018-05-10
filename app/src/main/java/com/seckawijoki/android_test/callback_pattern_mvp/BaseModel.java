package com.seckawijoki.android_test.callback_pattern_mvp;

/**
 * Created by seckawijoki on 18-5-5 at 下午8:55.
 */
public interface BaseModel<T extends BaseDataCallback> {
    void onPresenterInit();
    void onViewInit();
    void destroy();
    void setDataCallback(T actionCallback);
}
