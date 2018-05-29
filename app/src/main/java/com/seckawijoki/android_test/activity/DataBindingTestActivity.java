package com.seckawijoki.android_test.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.base.AbsActivity;
import com.seckawijoki.android_test.databinding.DataBindingTestActivityBinding;
import com.seckawijoki.android_test.model.DataBindingUser;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/29 at 10:52 under Windows-10 Professional.
 */
public class DataBindingTestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingTestActivityBinding binding =
                DataBindingUtil.setContentView(this, R.layout.data_binding_test_activity);
        DataBindingUser user = new DataBindingUser("ThinkPad-E431", "34563456");
        binding.setUserInfo(user);
    }
}
