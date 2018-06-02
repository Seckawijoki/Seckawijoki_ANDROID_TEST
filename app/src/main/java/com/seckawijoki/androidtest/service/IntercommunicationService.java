package com.seckawijoki.androidtest.service;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.base.AbsLifecycleService;
import com.seckawijoki.androidtest.binder.IntercommunicationBinder;
import com.seckawijoki.androidtest.constant.ReceiverAction;
import com.seckawijoki.androidtest.constant.ReceiverIntentKey;
import com.seckawijoki.androidtest.listener.OnUpdateFromServiceListener;
import com.seckawijoki.androidtest.util.ToastUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by seckawijoki on 2018-05-22 at 17:42 under Ubuntu-16.04 LTS.
 */
public class IntercommunicationService extends AbsLifecycleService{
  private static final String TAG = "CommunicationService";
  private OnUpdateFromServiceListener onUpdateFromServiceListener;
  private static final int MAX_PROGRESS = 10000;
  private int currentProgress;
  private ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
  private Runnable communicateDirectlyRunnable = new Runnable() {
    @Override
    public void run() {
       onUpdateFromServiceListener.onUpdateProgress(currentProgress+=5);
       if (currentProgress>= MAX_PROGRESS){
         onUpdateFromServiceListener.onUpdateProgress(MAX_PROGRESS);
         pool.shutdown();
       }
    }
  };
  private Runnable communicateViaReceiverRunnable = new Runnable() {
    Intent receiverIntent = new Intent(ReceiverAction.INTERCOMMUNICATION);
    @Override
    public void run() {
      receiverIntent.putExtra(ReceiverIntentKey.COMMUNICATION_PROGRESS, currentProgress+=50);
      sendBroadcast(receiverIntent);
      if (currentProgress>= MAX_PROGRESS){
        receiverIntent.putExtra(ReceiverIntentKey.COMMUNICATION_PROGRESS, MAX_PROGRESS);
        sendBroadcast(receiverIntent);
        pool.shutdown();
      }
    }
  };

  public void setOnUpdateFromServiceListener(OnUpdateFromServiceListener listener) {
    this.onUpdateFromServiceListener = listener;
  }
  public void startDownloadingDirectly(){
    currentProgress = 0;
    if (pool.isShutdown()){
      pool = Executors.newScheduledThreadPool(2);
    }
    pool.scheduleAtFixedRate(communicateDirectlyRunnable, 100, 5, TimeUnit.MILLISECONDS);
  }

  private void startDownloadingForReceiver(){
    currentProgress = 0;
    if (pool.isShutdown()){
      pool = Executors.newScheduledThreadPool(2);
    }
    pool.scheduleAtFixedRate(communicateViaReceiverRunnable, 200, 100, TimeUnit.MILLISECONDS);
  }

  public void stopDownloading(){
    pool.shutdownNow();
  }

  @Override
  public String setTag() {
    return TAG;
  }

  @Override
  public void onCreate() {
    super.onCreate();
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    startDownloadingForReceiver();
    return super.onStartCommand(intent, flags, startId);
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    super.onBind(intent);
    return new IntercommunicationBinder(this);
  }

  @Override
  public void onRebind(Intent intent) {
    super.onRebind(intent);
  }

  @Override
  public boolean onUnbind(Intent intent) {
    ToastUtil.makeText(this, R.string.intercommunication_unbind_service);
    stopDownloading();
    return super.onUnbind(intent);
  }


  @Override
  public void onDestroy() {
    super.onDestroy();
    stopDownloading();
  }

}
