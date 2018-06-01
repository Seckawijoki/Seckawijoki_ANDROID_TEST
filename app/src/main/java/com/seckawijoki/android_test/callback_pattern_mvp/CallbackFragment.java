package com.seckawijoki.android_test.callback_pattern_mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by seckawijoki on 18-5-5 at 下午9:20.
 */
public class CallbackFragment extends Fragment implements CallbackContract.View{
  private CallbackPresenterImpl presenter;
  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    presenter = new CallbackPresenterImpl();
    presenter.setView(new CallbackViewImpl());
    presenter.setModel(new CallbackModelImpl());
    presenter.initiate();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    presenter.destroy();
  }

  @Override
  public void displayCallback() {

  }

  @Override
  public void onPresenterInit() {

  }

  @Override
  public void onModelInit() {

  }

  @Override
  public void setActionCallback(ActionCallback actionCallback) {

  }
}
