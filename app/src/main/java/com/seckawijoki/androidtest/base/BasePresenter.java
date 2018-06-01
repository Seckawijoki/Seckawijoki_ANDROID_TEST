package com.seckawijoki.androidtest.base;

/**
 * Created by seckawijoki on 18-5-5 at 上午10:49.
 */
public interface BasePresenter<VIEW extends BaseView, MODEL extends BaseModel> {
    void start();
    void setView(VIEW view);
    void setModel(MODEL model);
}
