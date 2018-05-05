package com.seckawijoki.android_test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.base.RecyclerButton;
import com.seckawijoki.android_test.constant.IntentActions;

/**
 * Created by 瑶琴频曲羽衣魂 on 2017/6/22.
 */

public class OldTestActivity extends AppCompatActivity implements View.OnClickListener {
  private static final String TAG = OldTestActivity.class.getSimpleName();
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_old_test);
    Button btnTouchForLargening = (Button) findViewById(R.id.btn_touch_for_largening_activity);
    Button btnNavigationView = (Button) findViewById(R.id.btn_navigation_view_activity);
    final Button btnDateGrouped = (Button) findViewById(R.id.btn_date_grouped_activity);

    btnTouchForLargening.setOnClickListener(this);
    btnNavigationView.setOnClickListener(this);
    btnDateGrouped.setOnClickListener(this);

    findViewById(R.id.img).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Log.e(TAG, "onClick: ImageView");
      }
    });
//    btnTouchForLargening.performClick();

      RecyclerView rv = findViewById(R.id.rv_recycler_button_test);
      new RecyclerButton.Builder(this)
              .setColumn(3)
              .setRecyclerView(rv)
              .setTitleRes(R.array.array_main_activity_names)
              .setOnRecyclerButtonClickListener(new RecyclerButton.OnRecyclerButtonClickListener() {
                  @Override
                  public void onClick(int position) {
                      Log.d(TAG, "onClick(): position = " + position);
                  }
              })
              .build();
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.btn_navigation_view_activity:
        startActivity(new Intent(IntentActions.NAVIGATION_VIEW));
        break;
      case R.id.btn_touch_for_largening_activity:
        startActivity(new Intent(IntentActions.TOUCH_FOR_LARGENING));
        break;
      case R.id.btn_date_grouped_activity:
        startActivity(new Intent(IntentActions.DATE_GROUPED));
        break;
      case R.id.img:
        Log.e(TAG, "onClick: ImageView");
        break;
    }
  }
}
