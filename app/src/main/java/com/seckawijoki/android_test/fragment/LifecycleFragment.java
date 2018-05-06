package com.seckawijoki.android_test.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.base.AbsLifecycleLogFragment;
import com.seckawijoki.android_test.base.RecyclerButton;
import com.seckawijoki.android_test.constant.IntentActions;
import com.seckawijoki.android_test.dialog.ADialogFragment;

/**
 * Created by seckawijoki on 18-5-5 at 下午9:38.
 */
public class LifecycleFragment extends AbsLifecycleLogFragment implements RecyclerButton.OnRecyclerButtonClickListener {
  public static LifecycleFragment newInstance() {

    Bundle args = new Bundle();

    LifecycleFragment fragment = new LifecycleFragment();
    fragment.setArguments(args);
    return fragment;
  }
  @Override
  public String setTag() {
    return "LifecycleFragment";
  }

  @Override
  public int setLayout() {
    return R.layout.lifecycle_fragment;
  }

  @Override
  public void initView() {
    View view = getView();
    ((TextView) view.findViewById(R.id.tv_lifecycle_object_id)).setText(setTag()+toString());
    RecyclerView rv = view.findViewById(R.id.rv_operate_activity);
    new RecyclerButton.Builder(getActivity())
            .setVertical(3)
            .setTitleRes(R.array.array_lifecycle_operate_activity)
            .setRecyclerView(rv)
            .setOnRecyclerButtonClickListener(this)
            .build();
  }

  @Override
  public void onClick(int position) {
    switch (position){
      case 0:
        startActivity(new Intent(IntentActions.AN_ACTIVITY));
        break;
      case 1:
        startActivityForResult(new Intent(IntentActions.AN_ACTIVITY), 200);
        break;
      case 2:
        startActivity(new Intent(IntentActions.A_DIALOG_ACTIVITY));
        break;
      case 3:
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.lifecycle_dialog_title)
                .setMessage(R.string.lifecycle_dialog_content)
                .create();
        alertDialog.show();
        break;
      case 4:
        ADialogFragment aDialogFragment = ADialogFragment.newInstance();
        aDialogFragment.show(getActivity().getSupportFragmentManager(), null);
        break;

    }
  }
}
