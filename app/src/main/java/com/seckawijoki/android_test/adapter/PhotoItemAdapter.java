package com.seckawijoki.android_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seckawijoki.android_test.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 瑶琴频曲羽衣魂 on 2017/8/11.
 */

public class PhotoItemAdapter extends RecyclerView.Adapter<PhotoItemAdapter.ViewHolder>{
  private Context context;
  private List<Long> dateList;
  private final static DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance();
  public PhotoItemAdapter(Context context, List<Long> dateList) {
    this.context = context;
    this.dateList = dateList;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewHolder holder = new ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item_photo, parent, false));
    return holder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.tv.setText(dateFormat.format(new Date(dateList.get(position))));
  }

  @Override
  public int getItemCount() {
    return dateList.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder{
    TextView tv;
    ViewHolder(View itemView) {
      super(itemView);
      tv = (TextView) itemView.findViewById(R.id.tv_photo_item);
    }
  }
}
