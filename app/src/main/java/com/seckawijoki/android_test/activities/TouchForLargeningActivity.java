package com.seckawijoki.android_test.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.seckawijoki.android_test.adapters.TouchForLargeningAdapter;
import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.listener.TouchForLargeningListener;
import com.seckawijoki.android_test.utils.ToastUtils;
import com.xiaoleilu.hutool.date.DateUtil;

/**
 * Created by 瑶琴频曲羽衣魂 on 2017/6/22.
 */

public class TouchForLargeningActivity extends AppCompatActivity implements View.OnClickListener {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_touch_for_largening);
    RecyclerView rv = (RecyclerView) findViewById(R.id.rv_on_touch_largen);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    rv.setLayoutManager(layoutManager);
    TouchForLargeningAdapter adapter = new TouchForLargeningAdapter(this);
    rv.setAdapter(adapter);
    rv.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        int []locations = new int[2];
        v.getLocationOnScreen(locations);
        Log.d("RecyclerView", "x on screen = " + locations[0] + "y on screen = " + locations[1]);
        return true;
      }
    });

    rv.setOnDragListener(new View.OnDragListener() {
      @Override
      public boolean onDrag(View v, DragEvent event) {
        return false;
      }
    });

    Button btnFirst = (Button) findViewById(R.id.btn_first_touch);
    Button btnSecond = (Button) findViewById(R.id.btn_second_touch);
    btnFirst.setOnTouchListener(new TouchForLargeningListener(this));
    btnSecond.setOnTouchListener(new TouchForLargeningListener(this));
    btnFirst.setOnClickListener(this);
    btnSecond.setOnClickListener(this);

    DateUtil.date();
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.btn_first_touch:
        ToastUtils.makeText(this, "first click");
        break;
      case R.id.btn_second_touch:
        ToastUtils.makeText(this, "second click");
        break;
    }
  }
}
