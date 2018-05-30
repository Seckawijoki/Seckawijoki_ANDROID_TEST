package com.seckawijoki.android_test.javabean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/30 at 10:42 under Windows-10 Professional.
 */
public class DataBindingJavabean extends BaseObservable{
  private String privateField = "private";
  String defaultField = "default";
  protected String protectedField = "protected";
  @Bindable
  public String publicField = "public";

  @Bindable
  public String getPrivateField() {
    return privateField;
  }

  @Bindable
  public String getDefaultField() {
    return defaultField;
  }

  @Bindable
  public String getProtectedField() {
    return protectedField;
  }

  public String getPublicField() {
    return publicField;
  }

  public DataBindingJavabean setPrivateField(String privateField) {
    this.privateField = privateField;
    notifyPropertyChanged(com.seckawijoki.android_test.BR.privateField);
    return this;
  }

  public DataBindingJavabean setDefaultField(String defaultField) {
    this.defaultField = defaultField;
    notifyPropertyChanged(com.seckawijoki.android_test.BR.defaultField);
    return this;
  }

  public DataBindingJavabean setProtectedField(String protectedField) {
    this.protectedField = protectedField;
    notifyPropertyChanged(com.seckawijoki.android_test.BR.protectedField);
    return this;
  }

  public DataBindingJavabean setPublicField(String publicField) {
    this.publicField = publicField;
    notifyPropertyChanged(com.seckawijoki.android_test.BR.publicField);
    return this;
  }
}
