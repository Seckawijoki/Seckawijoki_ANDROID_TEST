package com.seckawijoki.android_test.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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

public class DateGroupedItemAdapter extends RecyclerView.Adapter<DateGroupedItemAdapter.ViewHolder>{
  private final static DateFormat dateFormat = SimpleDateFormat.getDateInstance();
  private Context context;
  private List<List<Long>> allDateList;
  public DateGroupedItemAdapter(Context context, List<List<Long>> allDateList) {
    this.context = context;
    this.allDateList = allDateList;
  }
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewHolder holder = new ViewHolder(
            LayoutInflater.from(context)
                    .inflate(R.layout.list_item_date_grouped_item, parent, false));
    return holder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    List<Long> dateList = allDateList.get(position);
    holder.tvDate.setText(dateFormat.format(
            new Date(dateList.get(0))
    ));
    final StaggeredGridLayoutManager layoutManager
            = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
    PhotoItemAdapter adapter = new PhotoItemAdapter(context, dateList);
    holder.rv.setLayoutManager(layoutManager);
    holder.rv.setAdapter(adapter);
  }

  @Override
  public int getItemCount() {
    return allDateList.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder{
    TextView tvDate;
    RecyclerView rv;
    public ViewHolder(View itemView) {
      super(itemView);
      tvDate = (TextView) itemView.findViewById(R.id.tv_date_time);
      rv = (RecyclerView) itemView.findViewById(R.id.rv_intraday_photos);
    }
  }
}
