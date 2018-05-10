package com.seckawijoki.android_test.callback_pattern_mvp;

/**
 * Created by seckawijoki on 18-5-5 at 下午9:03.
 */
public final class CallbackPresenterImpl
        implements CallbackContract.Presenter,
        CallbackContract.View.ActionCallback,
        CallbackContract.Model.DataCallback {
  private CallbackContract.View view;
  private CallbackContract.Model model;

  @Override
  public void setView(CallbackContract.View view) {
    this.view = view;
  }

  @Override
  public void setModel(CallbackContract.Model model) {
    this.model = model;
  }

  @Override
  public void initiate() {
    view.setActionCallback(this);
    model.setDataCallback(this);
    view.onPresenterInit();
    model.onPresenterInit();
    view.onModelInit();
    model.onViewInit();
  }

  @Override
  public void destroy() {
    view.setActionCallback(null);
    model.setDataCallback(null);
  }

  @Override
  public void onRequestCallback() {
    model.requestCallback();
  }

  @Override
  public void onDisplayCallback() {
    view.displayCallback();
  }
}
