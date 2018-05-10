package com.seckawijoki.android_test.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.adapter.CheckboxAdapter;
import com.seckawijoki.android_test.base.AbsActivity;

/**
 * Created by seckawijoki on 18-5-8 at 下午9:49.
 */
public class SingleChoiceRecyclerViewActivity extends AbsActivity {
  @Override
  public int setLayout() {
    return R.layout.single_choice_recycler_view_activity;
  }

  @Override
  protected void initView() {
    RecyclerView rvCheckbox = findViewById(R.id.rv_checkbox);
    rvCheckbox.setLayoutManager(new LinearLayoutManager(this));
    rvCheckbox.setAdapter(new CheckboxAdapter(this));
    RecyclerView rvRadioButton = findViewById(R.id.rv_radio_button);
  }
}
