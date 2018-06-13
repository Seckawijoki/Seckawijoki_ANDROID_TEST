package com.seckawijoki.androidtest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.base.RecyclerButton;
import com.seckawijoki.androidtest.constant.IntentActions;
import com.seckawijoki.androidtest.util.ToastUtil;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/11 at 16:25.
 */
public class MainFragment extends Fragment implements RecyclerButton.OnRecyclerButtonClickListener {
  public static MainFragment newInstance() {
    Bundle args = new Bundle();
    MainFragment fragment = new MainFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    setHasOptionsMenu(true);
    return inflater.inflate(R.layout.main_fragment, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    RecyclerView rv = view.findViewById(R.id.recycler_view_main);
    new RecyclerButton.Builder(getActivity())
            .setTitleRes(R.array.array_main_activity_names)
            .setRecyclerView(rv)
            .setWidth(120)
            .setHeight(120)
            .setReverseGrid(3)
            .setOnRecyclerButtonClickListener(this)
            .build();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

  }

  private void startActivity(String action) {
    startActivity(new Intent(action));
  }

  @Override
  public void onClick(int position) {
    switch (position) {
      default:
        ToastUtil.makeText(getContext(), R.string.app_name);
        break;
      case Activities.SOCKET_PROGRAMMING:
//        startActivity(new Intent(IntentActions.SOCKET_PROGRAMMING));
        break;
      case Activities.BAIDU_PUSH_FLOW:
//        startActivity(new Intent(IntentActions.BAIDU_PUSH_FLOW));
        break;
      case Activities.OLD_TEST:
        startActivity(new Intent(IntentActions.OLD_TEST));
        break;
      case Activities.MY_SERVICE_TEST:
        startActivity(new Intent(IntentActions.MY_SERVICE_TEST));
        break;
      case Activities.WHETHER_IN_UI_THREAD:
        startActivity(new Intent(IntentActions.WHETHER_IN_UI_THREAD));
        break;
      case Activities.LIFECYCLE:
        startActivity(new Intent(IntentActions.LIFECYCLE));
        break;
      case Activities.AMAP_TEST:
        startActivity(new Intent(IntentActions.AMAP_TEST));
        break;
      case Activities.ANIMATOR_TEST:
        startActivity(new Intent(IntentActions.ANIMATOR_TEST));
        break;
      case Activities.LAUNCH_MODE:
        startActivity(new Intent(IntentActions.LAUNCH_MODE));
        break;
      case Activities.COLLAPSING_TOOLBAR:
        startActivity(new Intent(IntentActions.COLLAPSING_TOOLBAR));
        break;
      case Activities.SINGLE_CHOICE_RECYCLER_VIEW:
        startActivity(IntentActions.SINGLE_CHOICE_RECYCLER_VIEW);
        break;
      case Activities.COMMUNICATION_BETWEEN_ACTIVITY_AND_SERVICE:
        startActivity(IntentActions.INTERCOMMUNICATION);
        break;
      case Activities.DATA_BINDING_TEST:
        startActivity(IntentActions.DATA_BINDING_TEST);
        break;
      case Activities.MY_ANDROID_LIBRARY_TEST:
        startActivity(IntentActions.MY_ANDROID_LIBRARY_TEST);
        break;
      case Activities.BUGLY_TEST:
        startActivity(IntentActions.BUGLY_TEST);
        break;
    }
  }

  public interface Activities {
    int OLD_TEST = 0;
    int MY_SERVICE_TEST = 1;
    int WHETHER_IN_UI_THREAD = 2;
    int LIFECYCLE = 3;
    int AMAP_TEST = 4;
    int ANIMATOR_TEST = 5;
    int LAUNCH_MODE = 6;
    int COLLAPSING_TOOLBAR = 7;
    int SINGLE_CHOICE_RECYCLER_VIEW = 8;
    int COMMUNICATION_BETWEEN_ACTIVITY_AND_SERVICE = 9;
    int DATA_BINDING_TEST = 10;
    int BUGLY_TEST = 11;
    int SOCKET_PROGRAMMING = 98;
    int BAIDU_PUSH_FLOW = 99;
    int MY_ANDROID_LIBRARY_TEST = 100;
  }
}