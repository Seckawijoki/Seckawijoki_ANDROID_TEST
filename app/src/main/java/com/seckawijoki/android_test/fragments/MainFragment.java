package com.seckawijoki.android_test.fragments;
/**
 * Created by 瑶琴频曲羽衣魂 on 2018/3/11 at 16:25.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.adapters.MainAdapter;
import com.seckawijoki.android_test.item_decoration.MainItemDecoration;

public class MainFragment extends Fragment {
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
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    RecyclerView rv = getView().findViewById(R.id.recycler_view_main);
    rv.setLayoutManager(new GridLayoutManager(getActivity(), 3,
            GridLayoutManager.VERTICAL, false));
    rv.addItemDecoration(new MainItemDecoration(getActivity()));
    rv.setAdapter(new MainAdapter(getActivity()));
  }

  @Override
  public void onDetach() {
    super.onDetach();
  }

}