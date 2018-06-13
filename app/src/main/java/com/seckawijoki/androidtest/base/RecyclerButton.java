package com.seckawijoki.androidtest.base;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ArrayRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.seckawijoki.androidtest.util.DensityUtil;

/**
 * Created by seckawijoki on 18-5-3 at 下午9:55.
 */
public final class RecyclerButton extends RecyclerView.Adapter<RecyclerButton.ViewHolder> {
  private static final String TAG = "RecyclerButton";
  private int width = 120;//dp
  private int height = 70;//dp
  private int padding = 8;//dp
  private float textSize = 16;//sp
  private int span = 3;
  private OnRecyclerButtonClickListener listener;
  private Context context;
  private RecyclerView rv;
  private String[] titles;
  private boolean debuggingLog = true;
  private RecyclerButton(){}

  public static class Builder {
    private RecyclerButton instance = new RecyclerButton();
    private RecyclerView.LayoutManager layoutManager = new GridLayoutManager(
            instance.context,
            instance.span,
            GridLayoutManager.VERTICAL,
            false);

    public Builder(Context context) {
      instance.context = context;
    }

    public Builder setRecyclerView(RecyclerView rv) {
      instance.rv = rv;
      return this;
    }

    public Builder setTitleRes(@ArrayRes int titleRes) {
      instance.titles = instance.context.getResources().getStringArray(titleRes);
      return this;
    }

    public Builder setTitleRes(String[] titles) {
      instance.titles = titles;
      return this;
    }

    public Builder setWidth(int dp) {
      instance.width = dp;
      return this;
    }

    public Builder setHeight(int dp) {
      instance.height = dp;
      return this;
    }

    public Builder setVertical() {
      layoutManager = new LinearLayoutManager(instance.context);
      return this;
    }

    public Builder debug(boolean debug){
      instance.debuggingLog = debug;
      return this;
    }

    public Builder setHorizontal() {
      layoutManager = new LinearLayoutManager(instance.context,
              LinearLayoutManager.HORIZONTAL,
              false);
      return this;
    }

    public Builder setReverseGrid(int column){
      instance.span = column;
      layoutManager = new GridLayoutManager(
              instance.context,
              column,
              GridLayoutManager.VERTICAL,
              true);
      return this;
    }

    public Builder setVertical(int column) {
      if (column <= 1) return setVertical();
      instance.span = column;
      layoutManager = new GridLayoutManager(
              instance.context,
              column,
              GridLayoutManager.VERTICAL,
              false);
      return this;
    }

    public Builder setHorizontal(int row) {
      if (row <= 1) return setHorizontal();
      instance.span = row;
      layoutManager = new GridLayoutManager(
              instance.context,
              row,
              GridLayoutManager.HORIZONTAL,
              false);
      return this;
    }

    public Builder setOnRecyclerButtonClickListener(OnRecyclerButtonClickListener listener) {
      instance.listener = listener;
      return this;
    }

    public RecyclerButton build() {
      instance.rv.setLayoutManager(layoutManager);
      instance.rv.setAdapter(instance);
      return instance;
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Button btn = new Button(context);
    int padding = DensityUtil.dp2px(context, this.padding);
    /*
    LayoutParams layoutParams = new LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT);
    btn.setLayoutParams(layoutParams);
    */
    btn.setWidth(DensityUtil.dp2px(context, width));
    btn.setHeight(DensityUtil.dp2px(context, height));
    btn.setPadding(padding, padding, padding, padding);
    btn.setTextColor(Color.BLACK);
    btn.setTextSize(textSize);
    btn.setAllCaps(false);
    return new ViewHolder(btn);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {
    holder.setText(titles[position]);
    final int p = position;
    holder.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Log.d(TAG, "onClick(): " + titles[p]);
        listener.onClick(p);
      }
    });
  }

  @Override
  public int getItemCount() {
    return titles == null ? 0 : titles.length;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    private Button btn;

    ViewHolder(View itemView) {
      super(itemView);
      btn = (Button) itemView;
    }

    void setText(String text) {
      btn.setText(text);
    }

    void setOnClickListener(View.OnClickListener onClickListener) {
      btn.setOnClickListener(onClickListener);
    }
  }

  public interface OnRecyclerButtonClickListener {
    void onClick(int position);
  }
}
