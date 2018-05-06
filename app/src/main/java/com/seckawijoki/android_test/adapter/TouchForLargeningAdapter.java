package com.seckawijoki.android_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.listener.TouchForLargeningListener;

/**
 * Created by 瑶琴频曲羽衣魂 on 2017/6/21.
 */

public class TouchForLargeningAdapter extends RecyclerView.Adapter<TouchForLargeningAdapter.ViewHolder> {
  private Context context;
  public TouchForLargeningAdapter(Context context) {
    this.context = context;
  }
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewHolder holder = new ViewHolder(
            LayoutInflater.from(context)
            .inflate(R.layout.list_item_touch_for_largening, parent, false)
    );
    holder.btn.setOnDragListener(new View.OnDragListener() {
      @Override
      public boolean onDrag(View v, DragEvent event) {
        return false;
      }
    });
    holder.btn.setOnTouchListener(new TouchForLargeningListener(context));
//    holder.btn.setOnFocusChangeListener(new CommonFocusChangeListener(context));
    return holder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.btn.setText(position + "");
  }

  @Override
  public int getItemCount() {
    return 50;
  }

  static class ViewHolder extends RecyclerView.ViewHolder{
    Button btn;
    public ViewHolder(View itemView) {
      super(itemView);
      btn = (Button) itemView.findViewById(R.id.btn_main);
    }
  }
}
