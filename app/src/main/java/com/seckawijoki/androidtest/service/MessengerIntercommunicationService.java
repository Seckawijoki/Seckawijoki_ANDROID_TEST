package com.seckawijoki.androidtest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by seckawijoki on 2018-05-25 at 00:01 under Ubuntu-16.04 LTS.
 */
public class MessengerIntercommunicationService extends Service{
  private static final String TAG = "MessengerCommunicate";
  private final Handler handler = new Handler(msg -> {
    Log.d(TAG, "Received data from remote activity: msg.obj = " + msg.obj);
    Message msgReply = Message.obtain();
    msgReply.obj = "From remote service";
    try {
      msg.replyTo.send(msgReply);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    return true;
  });
  private Messenger messenger = new Messenger(handler);
  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return messenger.getBinder();
  }

}
