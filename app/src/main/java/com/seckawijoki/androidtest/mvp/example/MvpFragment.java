package com.seckawijoki.androidtest.mvp.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by seckawijoki on 18-5-5 at 下午8:22.
 */
public class MvpFragment extends Fragment implements MvpContract.View {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void displayMvp() {

    }

    @Override
    public void setPresenter(MvpContract.Presenter presenter) {

    }
}
