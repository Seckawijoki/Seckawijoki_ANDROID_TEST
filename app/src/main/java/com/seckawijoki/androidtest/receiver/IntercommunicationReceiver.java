package com.seckawijoki.androidtest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.seckawijoki.androidtest.constant.ReceiverIntentKey;
import com.seckawijoki.androidtest.listener.OnUpdateFromReceiverListener;
import com.seckawijoki.androidtest.listener.OnUpdateFromServiceListener;

/**
 * Created by seckawijoki on 2018-05-22 at 17:39 under Ubuntu-16.04 LTS.
 */
public class IntercommunicationReceiver extends BroadcastReceiver {
//  private static final String TAG = "CommunicationReceiver";
  private OnUpdateFromReceiverListener onUpdateFromReceiverListener;

  public void setOnUpdateFromReceiverListener(OnUpdateFromReceiverListener listener) {
    this.onUpdateFromReceiverListener = listener;
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    if (onUpdateFromReceiverListener != null) {
      onUpdateFromReceiverListener.onUpdateProgress(intent.getIntExtra(
              ReceiverIntentKey.COMMUNICATION_PROGRESS, 0));
    }
  }
}
