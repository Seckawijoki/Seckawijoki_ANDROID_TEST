package com.seckawijoki.androidtest.adapter;
/**
 * Created by seckawijoki on 18-5-8 at 下午9:59.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.seckawijoki.androidtest.R;

public class CheckboxAdapter extends RecyclerView.Adapter<CheckboxAdapter.ViewHolder> {
  private static final String TAG = "CheckboxAdapter";
  private static final int WIDTH = 40;
  private static final int HEIGHT = 120;
  private static final int COUNT = 21;
  private Context context;
  private int currentPosition = -1;

  public CheckboxAdapter(Context context) {
    this.context = context;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    CheckBox chb = new CheckBox(context);
//    chb.setWidth(WIDTH);
//    chb.setHeight(HEIGHT);
    ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            HEIGHT
    );
    chb.setLayoutParams(layoutParams);
    chb.setGravity(Gravity.CENTER);
    return new ViewHolder(chb);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    Log.d(TAG, "onBindViewHolder(): currentPosition = " + currentPosition);
    Log.d(TAG, "onBindViewHolder(): position = " + position);
    final int p = holder.getAdapterPosition();
    holder.chb.setText(TAG + p);
    holder.chb.setChecked(currentPosition == position);
    View.OnClickListener listener1 = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        currentPosition = holder.getAdapterPosition();
        Log.d(TAG, "onClick(): currentPosition = " + currentPosition);
        Log.d(TAG, "onClick(): position = " + position);
        notifyDataSetChanged();
      }
    };
    View.OnClickListener listener2 = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
//        currentPosition = position;
        currentPosition = p;
        notifyDataSetChanged();
      }
    };
//    holder.chb.setOnClickListener(listener1);
    holder.chb.setOnClickListener(listener2);
  }

  @Override
  public int getItemCount() {
    return COUNT;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    CheckBox chb;
    ViewHolder(View view) {
      super(view);
      chb = ((CheckBox) view);
    }
  }
}