package com.seckawijoki.androidtest.mvp.example;

import com.seckawijoki.androidtest.base.BaseModel;
import com.seckawijoki.androidtest.base.BasePresenter;
import com.seckawijoki.androidtest.base.BaseView;

/**
 * Created by seckawijoki on 18-5-5 at 上午11:18.
 */
public interface MvpContract {
    interface View extends BaseView<Presenter>{
        void displayMvp();
    }
    interface Presenter extends BasePresenter<View, Model>{
        void onRequestMvp();
    }
    interface Model extends BaseModel<Model.DataCallback>{
        void requestMvp();
        interface DataCallback extends BaseModel.DataCallback{
            void onDisplayMvp();
        }
    }
}
