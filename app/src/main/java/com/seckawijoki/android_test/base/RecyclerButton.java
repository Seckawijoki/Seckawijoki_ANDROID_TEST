package com.seckawijoki.android_test.base;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ArrayRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.seckawijoki.android_test.util.DensityUtil;

/**
 * Created by seckawijoki on 18-5-3 at 下午9:55.
 */
public final class RecyclerButton extends RecyclerView.Adapter<RecyclerButton.ViewHolder> {
//    private static final String TAG = "RecyclerButton";
    private static final int WIDTH = 120;//dp
    private static final int HEIGHT = 100;//dp
    private static final int PADDING = 8;//dp
    private static final float TEXT_SIZE = 16;//sp
    private int column = 3;
    private OnRecyclerButtonClickListener listener;
    private Context context;
    private RecyclerView rv;
    private String[] titles;

    public static class Builder {
        private RecyclerButton instance = new RecyclerButton();

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

        public Builder setColumn(int column) {
            instance.column = column;
            return this;
        }

        public Builder setOnRecyclerButtonClickListener(OnRecyclerButtonClickListener listener) {
            instance.listener = listener;
            return this;
        }

        public RecyclerButton build() {
            instance.rv.setLayoutManager(
                    new GridLayoutManager(instance.context, instance.column, GridLayoutManager
                            .VERTICAL, false));
            instance.rv.setAdapter(instance);
            return instance;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button btn = new Button(context);
        int padding = DensityUtil.dp2px(context, PADDING);
        btn.setWidth(DensityUtil.dp2px(context, WIDTH));
        btn.setHeight(DensityUtil.dp2px(context, HEIGHT));
        btn.setPadding(padding, padding, padding, padding);
        btn.setTextColor(Color.BLACK);
        btn.setTextSize(TEXT_SIZE);
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
