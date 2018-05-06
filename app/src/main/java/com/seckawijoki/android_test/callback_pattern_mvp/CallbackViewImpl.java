package com.seckawijoki.android_test.callback_pattern_mvp;

/**
 * Created by seckawijoki on 18-5-5 at 下午9:09.
 */
public class CallbackViewImpl implements CallbackContract.View{
  private  ActionCallback actionCallback;
  @Override
  public void displayCallback() {
    // TODO: 18-5-5
  }

  @Override
  public void onPresenterInit() {
    // TODO: 18-5-5
  }

  @Override
  public void onModelInit() {
    // TODO: 18-5-5
  }

  @Override
  public void setActionCallback(ActionCallback actionCallback) {
    this.actionCallback = actionCallback;
  }
}
