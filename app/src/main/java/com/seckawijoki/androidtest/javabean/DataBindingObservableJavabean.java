package com.seckawijoki.androidtest.javabean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import java.util.Observable;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/30 at 10:45 under Windows-10 Professional.
 */
public class DataBindingObservableJavabean extends BaseObservable{
  private ObservableField<String> privateField = new ObservableField<>();
  @Bindable
  ObservableField<String> defaultField = new ObservableField<>();
  @Bindable
  protected ObservableField<String> protectedField = new ObservableField<>();
  @Bindable
  public ObservableField<String> publicField = new ObservableField<>();

  @Bindable
  public ObservableField<String> getPrivateField() {
    return privateField;
  }

  public ObservableField<String> getDefaultField() {
    return defaultField;
  }

  public ObservableField<String> getProtectedField() {
    return protectedField;
  }

  public ObservableField<String> getPublicField() {
    return publicField;
  }


  public DataBindingObservableJavabean setPrivateField(String privateField) {
    this.privateField.set(privateField);
    return this;
  }

  public DataBindingObservableJavabean setDefaultField(String defaultField) {
    this.defaultField.set(defaultField);
    return this;
  }

  public DataBindingObservableJavabean setProtectedField(String protectedField) {
    this.protectedField .set(protectedField);
    return this;
  }

  public DataBindingObservableJavabean setPublicField(String publicField) {
    this.publicField.set(publicField);
    return this;
  }

}
