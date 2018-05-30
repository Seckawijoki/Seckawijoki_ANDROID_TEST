package com.seckawijoki.android_test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.base.AbsLifecycleLogActivity;
import com.seckawijoki.android_test.base.RecyclerButton;
import com.seckawijoki.android_test.constant.IntentActions;
import com.seckawijoki.android_test.dialog.ADialogFragment;
import com.seckawijoki.android_test.fragment.LifecycleFragment;
import com.seckawijoki.android_test.util.ToastUtil;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/20 at 15:53.
 */

public class LifecycleActivity extends AbsLifecycleLogActivity {
  private static final String TAG = "LifecycleActivity";
  private boolean replaced = false;
  private LifecycleFragment fragment = LifecycleFragment.newInstance();
  private LifecycleFragment theOtherFragment = LifecycleFragment.newInstance();
  private FragmentManager fragmentManager;
  private FragmentTransaction fragmentTransaction;

  @Override
  public String setTag() {
    return TAG;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.lifecycle_activity);
    ((TextView) this.findViewById(R.id.tv_lifecycle_object_id)).setText(setTag()+toString());
    new RecyclerButton.Builder(this)
            .setTitleRes(R.array.array_lifecycle_operate_activity)
            .setRecyclerView(findViewById(R.id.rv_operate_activity))
            .setVertical(2)
            .setOnRecyclerButtonClickListener(activityOperationListener)
            .build();
    new RecyclerButton.Builder(this)
            .setTitleRes(R.array.array_lifecycle_operate_fragment)
            .setRecyclerView(findViewById(R.id.rv_operate_fragment))
            .setVertical(4)
            .setOnRecyclerButtonClickListener(fragmentOperationListener)
            .build();
    fragmentManager = getSupportFragmentManager();
    fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.fragment_lifecycle, fragment);
    fragmentTransaction.commitNow();
  }

  private RecyclerButton.OnRecyclerButtonClickListener activityOperationListener =
          position -> {
            switch (position) {
              case 0:
                startActivity(new Intent(IntentActions.AN_ACTIVITY));
                break;
              case 1:
                startActivityForResult(new Intent(IntentActions.AN_ACTIVITY), 100);
                break;
              case 2:
                startActivity(new Intent(IntentActions.A_DIALOG_ACTIVITY));
                break;
              case 3:
                AlertDialog alertDialog = new AlertDialog.Builder(LifecycleActivity.this)
                        .setTitle(R.string.lifecycle_dialog_title)
                        .setMessage(R.string.lifecycle_dialog_content)
                        .create();
                alertDialog.show();
                break;
              case 4:
                ADialogFragment aDialogFragment = ADialogFragment.newInstance();
                aDialogFragment.show(getSupportFragmentManager(), null);
                break;

            }
          };

  private RecyclerButton.OnRecyclerButtonClickListener fragmentOperationListener =
          new RecyclerButton.OnRecyclerButtonClickListener() {
            @Override
            public void onClick(int position) {
              try {
                switch (position) {
                  case 0:
                    fragmentManager = getSupportFragmentManager();
                    break;
                  case 1:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    break;
                  case 2:
                    fragmentTransaction.add(fragment, null);
                    break;
                  case 3:
                    fragmentTransaction.remove(fragment);
                    break;
                  case 4:
                    fragmentTransaction.show(fragment);
                    break;
                  case 5:
                    fragmentTransaction.hide(fragment);
                    break;
                  case 6:
                    fragmentTransaction.replace(R.id.fragment_lifecycle, replaced ? fragment : theOtherFragment);
                    replaced = !replaced;
                    break;
                  case 7:
                    Log.i(TAG, "onClick(): ");
                    fragmentTransaction.commit();
                    break;
                }
              } catch (Exception e) {
                ToastUtil.makeText(LifecycleActivity.this, e.toString());
                Log.e(TAG, "onClick(): e", e);
              }

            }
          };


}
