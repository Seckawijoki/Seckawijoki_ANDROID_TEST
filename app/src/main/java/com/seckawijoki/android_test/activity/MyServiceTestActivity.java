package com.seckawijoki.android_test.activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.fragment.MyServiceTestFragment;
import com.seckawijoki.android_test.util.ActivityUtil;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/11 at 16:08.
 */

public class MyServiceTestActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.my_service_test_activity);

    MyServiceTestFragment fragment = (MyServiceTestFragment)
            getSupportFragmentManager().findFragmentById(R.id.layout_my_service_test_fragment);
    if ( fragment == null ) {
      fragment = MyServiceTestFragment.newInstance();
      ActivityUtil.addFragmentToActivity(
              getSupportFragmentManager(), fragment, R.id.layout_my_service_test_fragment
      );
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return true;
  }
}