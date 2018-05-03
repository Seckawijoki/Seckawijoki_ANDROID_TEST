package com.seckawijoki.android_test.adapters;
/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/8 at 20:23.
 */

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.constants.IntentActions;
import com.seckawijoki.android_test.listener.OnMainActivitiesListener;

public final class MainAdapter
        extends RecyclerView.Adapter<MainAdapter.ViewHolder>
        implements OnMainActivitiesListener{
  @Override
  public void onMainActivitiesClick(int position) {
    switch ( position ){
      default:
      case Activities.OLD_TEST:
        mActivity.startActivity(new Intent(IntentActions.OLD_TEST));
        break;
      case Activities.MY_SERVICE_TEST:
        mActivity.startActivity(new Intent(IntentActions.MY_SERVICE_TEST));
        break;
      case Activities.WHETHER_IN_UI_THREAD:
        mActivity.startActivity(new Intent(IntentActions.WHETHER_IN_UI_THREAD));
        break;
      case Activities.LIFECYCLE:
        mActivity.startActivity(new Intent(IntentActions.LIFECYCLE));
        break;
      case Activities.AMAP_TEST:
        mActivity.startActivity(new Intent(IntentActions.AMAP_TEST));
        break;
      case Activities.SOCKET_PROGRAMMING:
        mActivity.startActivity(new Intent(IntentActions.SOCKET_PROGRAMMING));
        break;
      case Activities.ANIMATOR_TEST:
        mActivity.startActivity(new Intent(IntentActions.ANIMATOR_TEST));
        break;
      case Activities.LAUNCH_MODE:
        mActivity.startActivity(new Intent(IntentActions.LAUNCH_MODE));
        break;
    }
  }

  interface Activities {
    int OLD_TEST = 0;
    int MY_SERVICE_TEST = 1;
    int WHETHER_IN_UI_THREAD = 2;
    int LIFECYCLE = 3;
    int AMAP_TEST = 4;
    int SOCKET_PROGRAMMING = 5;
    int ANIMATOR_TEST = 6;
    int LAUNCH_MODE = 7;
    int count = 8;
  }
  private Activity mActivity;
  private String[] mNames;
  public MainAdapter(Activity activity) {
    mActivity = activity;
    mNames = activity.getResources().getStringArray(R.array.main_activity_names);
  }
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mActivity).inflate(R.layout.main_recycle_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    final int p = position;
    holder.btn.setText(mNames[position]);
    holder.btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onMainActivitiesClick(p);
      }
    });
  }

  @Override
  public int getItemCount() {
    return Activities.count;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    Button btn;
    ViewHolder(View view) {
      super(view);
      btn = (Button) view.findViewById(R.id.btn_main);
    }
  }
}