package com.seckawijoki.android_test.activity;

import android.databinding.BaseObservable;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.databinding.ViewStubProxy;
import android.databinding.adapters.ViewStubBindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.databinding.DataBindingTestActivityBinding;
import com.seckawijoki.android_test.fragment.DataBindingTestFragment;
import com.seckawijoki.android_test.javabean.DataBindingGoods;
import com.seckawijoki.android_test.javabean.DataBindingJavabean;
import com.seckawijoki.android_test.javabean.DataBindingObservableGoods;
import com.seckawijoki.android_test.javabean.DataBindingObservableJavabean;
import com.seckawijoki.android_test.javabean.DataBindingUser;
import com.seckawijoki.android_test.util.ToastUtil;

import java.util.Random;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/29 at 10:52 under Windows-10 Professional.
 * Android 原带的DataBinding的测试，包括以下几点：
 * 1.基本用法
 * 2.观察者模式更新UI
 * 3.使用Observable类
 * 4.Observable集合类用法
 * 5.双向绑定
 * 6.绑定事件
 * 7.布局文件的include用法
 * 8.ViewStub用法。
 * 9.Fragment下的DataBinding的使用方法
 */
public class DataBindingTestActivity extends AppCompatActivity implements View.OnClickListener {
  private static final String TAG = "DataBindingTestActivity";
  private DataBindingTestActivityBinding binding;
  private DataBindingUser user;
  private DataBindingGoods goods;
  private DataBindingObservableGoods goods2;
  private ObservableArrayMap<String, String> observableArrayMap;
  private ObservableList<String> observableList;
  private DataBindingTestFragment fragment;
  private DataBindingJavabean javabean;
  private DataBindingObservableJavabean observableJavabean;

  /**
   * 1.基本用法。
   * 布局文件转化DataBinding模式，声明data、variable、import等。
   *  Activity文件使用自生成类XXXBinding传入Javabean类。
   */
  private void dataBindingSimpleTest() {
    user = new DataBindingUser("ThinkPad-E431", "34563456");
    binding.setUserInfo(user);
  }

  /**
   * 2.观察者模式更新UI。
   * 使Javabean继承{@link android.databinding.BaseObservable}，
   * 在相应的setter方法下，调用{@link android.databinding.BaseObservable#notifyPropertyChanged(int)}
   * 更新某个成员变量绑定的UI控件，或者调用{@link BaseObservable#notifyChange()}更新所有成员变量的UI。
   */
  private void dataBindingNotificationTest() {
    goods = new DataBindingGoods("code", "hi", 24);
    binding.setGoods(goods);
    binding.setGoodsHandler(new GoodsHandler());
    Observable.OnPropertyChangedCallback onPropertyChangedCallback = new Observable.OnPropertyChangedCallback() {
      @Override
      public void onPropertyChanged(Observable sender, int propertyId) {
        if ( propertyId == com.seckawijoki.android_test.BR.name ) {
          Log.i(TAG, "BR.name");
        } else if ( propertyId == com.seckawijoki.android_test.BR.details ) {
          Log.i(TAG, "BR.details");
        } else if ( propertyId == com.seckawijoki.android_test.BR._all ) {
          Log.i(TAG, "BR._all");
        } else {
          Log.e(TAG, "未知");
        }
      }
    };
    goods.addOnPropertyChangedCallback(onPropertyChangedCallback);
  }

  /**
   * 3.使用Observable类。
   * 可自动更新。
   */
  private void dataBindingObservableFieldTest() {
    goods2 = new DataBindingObservableGoods("code", "hi", 24);
    binding.setObservableGoods(goods2);
    binding.setGoodsHandler(new GoodsHandler());
  }

  /**
   * 4.Observable集合类用法。
   *
   */
  private void dataBindingObservableCollectionTest() {
    observableArrayMap = new ObservableArrayMap<>();
    observableList = new ObservableArrayList<>();
    observableArrayMap.put("name", "seckawijoki");
    observableArrayMap.put("age", "22");
    observableList.add("first");
    observableList.add("second");
    binding.setMap(observableArrayMap);
    binding.setList(observableList);
    binding.setIndex(0);
    binding.setKey("name");
  }

  /**
   * 5.双向绑定。
   * UI和Javabean的更新会互相通知。
   */
  private void doubleDataBinding() {
    //为TextView的android:text=“@{userInfo.name}”
    //而TextView的android:text=“@={userInfo.name}”
    //@的后面多了一个赋值符号=
  }

  /**
   * 6.绑定事件。
   * 声明一个公共类，里面包含的公共方法，即用来更新UI。
   */
  private void dataBindingEventTest() {
    binding.setUserPresenter(new DataBindingUserPresenter());
  }

  /**
   * 7.布局文件的include用法。
   * 在include标签下通过bind传递variable变量。两个布局文件下声明的变量要相同。
   */
  private void dataBindingViewInclude(){

  }

  /**
   * 8.ViewStub用法。
   * 同样在viewStub标签下，通过bind绑定相应的变量。
   */
  private void dataBindingViewStub() {
    ViewStub viewStub = binding.viewStubDataBindingTest.getViewStub();
    View view = viewStub.inflate();
  }

  /**
   * 9.Fragment下的DataBinding的使用方法
   */
  private void dataBindingJavabeanAccessSpecifiers(){
    javabean = new DataBindingJavabean();
    observableJavabean = new DataBindingObservableJavabean();
    binding.setJavabean(javabean);
    binding.setObservableJavabean(observableJavabean);
    binding.setJavabeanHandler(new DataBindingJavabeanHandler());
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    Log.i(TAG, "onCreate(): ");
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.data_binding_test_activity);
    initiateDataBindingTestFragment();
    dataBindingSimpleTest();
    dataBindingNotificationTest();
    dataBindingObservableFieldTest();
    dataBindingObservableCollectionTest();
    doubleDataBinding();
    dataBindingEventTest();
    dataBindingViewInclude();
    dataBindingViewStub();
    dataBindingJavabeanAccessSpecifiers();
  }

  @Override
  protected void onStart() {
    Log.i(TAG, "onStart(): ");
    super.onStart();
  }

  @Override
  protected void onResume() {
    Log.i(TAG, "onResume(): ");
    super.onResume();
  }

  @Override
  protected void onResumeFragments() {
    Log.i(TAG, "onResumeFragments(): ");
    super.onResumeFragments();
    fragment.setUserInfo(user);
    fragment.setUserPresenter(new DataBindingUserPresenter());
  }

  private void initiateDataBindingTestFragment() {
    fragment = DataBindingTestFragment.newInstance();
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.fragment_data_binding_test, fragment);
    fragmentTransaction.commitNow();
  }

  @Override
  public void onClick(View v) {
    observableArrayMap.put("name", "map" + new Random().nextInt(100));
    observableList.set(0, "list"+new Random().nextInt(100));
  }

  public class DataBindingJavabeanHandler {
    public void changePrivate(){
      javabean.setPrivateField("private" + new Random().nextInt(100) );
      observableJavabean.setPrivateField("private" + new Random().nextInt(100) );
    }
    public void changeDefault(){
      javabean.setDefaultField("default" + new Random().nextInt(100) );
      observableJavabean.setDefaultField("default" + new Random().nextInt(100) );
    }
    public void changeProtected(){
      javabean.setProtectedField("protected" + new Random().nextInt(100) );
      observableJavabean.setProtectedField("protected" + new Random().nextInt(100) );
    }
    public void changePublic(){
      javabean.setPublicField("public" + new Random().nextInt(100) );
      observableJavabean.setPublicField("public" + new Random().nextInt(100) );
    }
  }

  public class GoodsHandler {
    public void changeGoodsName() {
      if ( goods != null ) {
        goods.setName("code" + new Random().nextInt(100));
        goods.setPrice(new Random().nextInt(100));
      }
      if ( goods2 != null ) {
        goods2.setName("code" + new Random().nextInt(100));
        goods2.setPrice(new Random().nextInt(100));
      }
    }

    public void changeGoodsDetails() {
      if ( goods != null ) {
        goods.setDetails("hi" + new Random().nextInt(100));
        goods.setPrice(new Random().nextInt(100));
      }
      if ( goods2 != null ) {
        goods2.setDetails("hi" + new Random().nextInt(100));
        goods2.setPrice(new Random().nextInt(100));
      }
    }
  }

  public class DataBindingUserPresenter {
    public void onUserNameClick(DataBindingUser user) {
      ToastUtil.makeText(DataBindingTestActivity.this, "用户名：" + user.getName());
    }

    public void afterUsernameChange(Editable e) {
      user.setName(e.toString());
      binding.setUserInfo(user);
      if ( fragment != null ) {
        fragment.setUserInfo(user);
      }
    }

    public void afterPasswordChange(Editable e) {
      user.setPassword(e.toString());
      binding.setUserInfo(user);
      if ( fragment != null ) {
        fragment.setUserInfo(user);
      }
    }
  }

  @BindingConversion
  public static Drawable convertStringToColor(String str){
    if (str.equals("红色")) {
      return new ColorDrawable(Color.parseColor("#FF4081"));
    }
    if (str.equals("蓝色")) {
      return new ColorDrawable(Color.parseColor("#3F51B5"));
    }
    return new ColorDrawable(Color.parseColor("#344567"));
  }
}
