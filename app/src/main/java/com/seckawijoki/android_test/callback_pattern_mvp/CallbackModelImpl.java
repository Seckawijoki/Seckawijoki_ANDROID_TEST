package com.seckawijoki.android_test.callback_pattern_mvp;

/**
 * Created by seckawijoki on 18-5-5 at 下午9:09.
 */
public final class CallbackModelImpl implements CallbackContract.Model{

  private DataCallback dataCallback;
  @Override
  public void requestCallback() {
    // TODO: 18-5-5
  }

  @Override
  public void onPresenterInit() {
    // TODO: 18-5-5
  }

  @Override
  public void onViewInit() {
    // TODO: 18-5-5
  }

  @Override
  public void destroy() {
    // TODO: 18-5-5
  }

  @Override
  public void setDataCallback(DataCallback actionCallback) {
    this.dataCallback = dataCallback;
  }
}
