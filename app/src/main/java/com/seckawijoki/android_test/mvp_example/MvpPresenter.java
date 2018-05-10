package com.seckawijoki.android_test.mvp_example;

/**
 * Created by seckawijoki on 18-5-5 at 下午8:30.
 */
public final class MvpPresenter implements MvpContract.Presenter{
    private MvpContract.View view;
    private MvpContract.Model model;
    @Override
    public void onRequestMvp() {

    }


    @Override
    public void start() {

    }

    @Override
    public void setView(MvpContract.View view) {

        this.view = view;
    }

    @Override
    public void setModel(MvpContract.Model model) {
        this.model = model;

    }
}
