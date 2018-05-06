package com.seckawijoki.android_test.activity;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.base.AbsActivity;

/**
 * Created by seckawijoki on 18-5-6 at 下午8:15.
 */
public class CollapsingToolbarActivity extends AbsActivity{

  @Override
  public int setLayout() {
    return R.layout.collapsing_toolbar_activity;
  }

  @Override
  protected void initView() {
    CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
    ImageView img = findViewById(R.id.img_collapsing_toolbar);
    Toolbar tb = findViewById(R.id.tb_collapsing_toolbar);
    setSupportActionBar(tb);
    tb.setNavigationIcon(R.mipmap.ic_clear);
    collapsingToolbarLayout.setTitle("CollapsingToolbar");
    collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
    img.setImageResource(R.drawable.img);
  }
}
