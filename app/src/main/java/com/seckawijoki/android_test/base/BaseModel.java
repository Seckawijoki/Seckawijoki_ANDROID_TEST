package com.seckawijoki.android_test.base;

/**
 * Created by seckawijoki on 18-5-5 at 下午8:33.
 */
public interface BaseModel<T extends BaseModel.DataCallback> {
    void setDataCallback(T dataCallback);
    interface DataCallback{

    }
}
