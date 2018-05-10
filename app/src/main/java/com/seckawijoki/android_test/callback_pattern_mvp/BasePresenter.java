package com.seckawijoki.android_test.callback_pattern_mvp;

/**
 * Created by seckawijoki on 18-5-5 at 下午9:00.
 */
public interface BasePresenter<V extends BaseView, M extends BaseModel>{
    void setView(V view);
    void setModel(M model);
    void initiate();
    void destroy();
}
