package com.seckawijoki.android_test.callback_pattern_mvp;

/**
 * Created by seckawijoki on 18-5-5 at 下午8:52.
 */
public interface CallbackContract {
    interface View extends BaseView<View.ActionCallback> {
        void displayCallback();
        interface ActionCallback extends BaseActionCallback{
            void onRequestCallback();
        }
    }
    interface Presenter extends BasePresenter<View, Model>{

    }
    interface Model extends BaseModel<Model.DataCallback>{
        void requestCallback();
        interface DataCallback extends BaseDataCallback{
            void onDisplayCallback();
        }
    }
}
