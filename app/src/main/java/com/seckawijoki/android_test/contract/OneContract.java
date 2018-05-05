package com.seckawijoki.android_test.contract;

import com.seckawijoki.android_test.base.BasePresenter;
import com.seckawijoki.android_test.base.BaseView;

/**
 * Created by seckawijoki on 18-5-5 at 上午11:18.
 */
public interface OneContract {
    interface View extends BaseView<Presenter>{
        void displayOne();
    }
    interface Presenter extends BasePresenter{
        void onRequestOne();
    }
}
