package com.seckawijoki.androidtest.design_pattern.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.seckawijoki.androidtest.R;

/**
 * 适配器模式
 * 仿RecyclerView写法
 * Created by Seckawijoki on 2019/8/17 at 22:52 under Windows-10 Professional.
 */
public class CircleMenuLayout extends ViewGroup {
  private int mRadius;
  private static final float RADIO_DEFAULT_CHILDE_DIMENSION = 1/4F;
  private static final float RADIO_PADDING_LAYOUT = 1/12F;
  private float mPadding;
  private double mStartAngle = 0;
  private String[] mItemTexts;
  private int[] mItemImgs;private int mMenuItemCount;
  private int mMenuItemLayoutd = R.layout.circle_menu_item;
  private OnItemClickListener mOnItemClickListener;

  interface OnItemClickListener {
    void onClick(int pos);
  }

  public CircleMenuLayout(Context context) {
    super(context);
    setPadding(0, 0, 0, 0);
  }

  @Override
  protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

  }
}
