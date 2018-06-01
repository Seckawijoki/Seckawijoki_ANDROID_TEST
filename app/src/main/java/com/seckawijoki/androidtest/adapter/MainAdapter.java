package com.seckawijoki.androidtest.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.constant.IntentActions;
import com.seckawijoki.androidtest.fragment.MainFragment;
import com.seckawijoki.androidtest.listener.OnMainActivitiesListener;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/8 at 20:23.
 */
@Deprecated
public final class MainAdapter
        extends RecyclerView.Adapter<MainAdapter.ViewHolder>
        implements OnMainActivitiesListener{
  @Override
  public void onMainActivitiesClick(int position) {
    switch ( position ){
      default:
      case MainFragment.Activities.OLD_TEST:
        mActivity.startActivity(new Intent(IntentActions.OLD_TEST));
        break;
      case MainFragment.Activities.MY_SERVICE_TEST:
        mActivity.startActivity(new Intent(IntentActions.MY_SERVICE_TEST));
        break;
      case MainFragment.Activities.WHETHER_IN_UI_THREAD:
        mActivity.startActivity(new Intent(IntentActions.WHETHER_IN_UI_THREAD));
        break;
      case MainFragment.Activities.LIFECYCLE:
        mActivity.startActivity(new Intent(IntentActions.LIFECYCLE));
        break;
      case MainFragment.Activities.AMAP_TEST:
        mActivity.startActivity(new Intent(IntentActions.AMAP_TEST));
        break;
      case MainFragment.Activities.SOCKET_PROGRAMMING:
        mActivity.startActivity(new Intent(IntentActions.SOCKET_PROGRAMMING));
        break;
      case MainFragment.Activities.ANIMATOR_TEST:
        mActivity.startActivity(new Intent(IntentActions.ANIMATOR_TEST));
        break;
      case MainFragment.Activities.LAUNCH_MODE:
        mActivity.startActivity(new Intent(IntentActions.LAUNCH_MODE));
        break;
    }
  }

  private Activity mActivity;
  private String[] mNames;
  public MainAdapter(Activity activity) {
    mActivity = activity;
    mNames = activity.getResources().getStringArray(R.array.array_main_activity_names);
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
    holder.btn.setOnClickListener(v -> onMainActivitiesClick(p));
  }

  @Override
  public int getItemCount() {
    return 0;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    Button btn;
    ViewHolder(View view) {
      super(view);
      btn = view.findViewById(R.id.btn_main);
    }
  }
}