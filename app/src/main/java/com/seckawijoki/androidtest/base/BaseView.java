package com.seckawijoki.androidtest.base;

/**
 * Created by seckawijoki on 18-5-5 at 上午11:15.
 */
public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
