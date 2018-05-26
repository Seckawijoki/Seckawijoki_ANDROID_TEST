package com.seckawijoki.android_test.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.aidl.ISomeRemoteService;
import com.seckawijoki.android_test.base.AbsActivity;
import com.seckawijoki.android_test.binder.IntercommunicationBinder;
import com.seckawijoki.android_test.constant.ReceiverAction;
import com.seckawijoki.android_test.constant.ServiceAction;
import com.seckawijoki.android_test.listener.OnUpdateFromReceiverListener;
import com.seckawijoki.android_test.listener.OnUpdateFromServiceListener;
import com.seckawijoki.android_test.receiver.IntercommunicationReceiver;
import com.seckawijoki.android_test.service.IntercommunicationService;
import com.seckawijoki.android_test.util.ToastUtil;


/**
 * Activity与Service通信的三种方法。
 * Created by seckawijoki on 2018-05-22 at 17:40 under Ubuntu-16.04 LTS.
 */
public class IntercommunicationActivity extends AbsActivity
        implements View.OnClickListener, OnUpdateFromServiceListener, OnUpdateFromReceiverListener {
  private static final String TAG = "Intercommunication";
  private ProgressBar progressBar;
  private TextView tvProgress;
  private IntercommunicationReceiver receiver;
  private IntercommunicationService service;
  private ServiceConnection directServiceConnection;
  private ServiceConnection serviceConnectionWithMessenger;
  private Messenger senderMessenger;
  private Messenger receiverMessenger;
  private ISomeRemoteService iSomeRemoteService;
  private ServiceConnection remoteServiceConnection;

  @Override
  public int setLayout() {
    return R.layout.intercommunication_activity;
  }


  @Override
  protected void initView() {
    progressBar = findViewById(R.id.pb_update_from_service);
    tvProgress = findViewById(R.id.tv_progress);
    communicateDirectly();
    communicateViaBroadcastReceiver();
    communicateWithMessenger();
    communicateViaAIDL();
  }

  /**
   * 方法一：
   * 通过{@link #bindService(Intent, ServiceConnection, int)}绑定{@link android.app.Service}，
   * 其中传递的{@link ServiceConnection} 实例连接Activity和Service，
   * 并在重写方法{@link ServiceConnection#onServiceConnected(ComponentName, IBinder)}
   * 的参数{@link IBinder}中， 获取Service实例，并使Service实现接口的方式进行相互通信。
   */
  private void communicateDirectly() {
    directServiceConnection = new ServiceConnection() {
      @Override
      public void onServiceConnected(ComponentName name, IBinder iBinder) {
        IntercommunicationBinder binder =                ((IntercommunicationBinder) iBinder);
        service = (IntercommunicationService) binder.getService();
        service.setOnUpdateFromServiceListener(IntercommunicationActivity.this);
        service.startDownloadingDirectly();
      }

      @Override
      public void onServiceDisconnected(ComponentName name) {

      }
    };
  }

  /**
   * 方法二：
   * 首先在Activity里{@link #registerReceiver(BroadcastReceiver, IntentFilter)}注册
   * 我们需要接收数据的{@link BroadcastReceiver}，
   * 然后调用{@link #startService(Intent)}启动一次{@link android.app.Service}时，
   * 在{@link android.app.Service#onStartCommand(Intent, int, int)}中启动的执行耗时操作的新线程里，
   * 通过{@link #sendBroadcast(Intent)}方法向广播传递数据，最终我们的广播实例，通过接口回调的形式，
   * 得到Service传来的数据。
   */
  private void communicateViaBroadcastReceiver() {
    receiver = new IntercommunicationReceiver();
    receiver.setOnUpdateFromReceiverListener(this);
    IntentFilter intentFilter = new IntentFilter(ReceiverAction.INTERCOMMUNICATION);
    registerReceiver(receiver, intentFilter);
  }

  /**
   * 方法三：
   * Activity中实现了两个{@link Messenger}，一个是发送者、一个是接收者。
   * 接收者Messenger通过绑定一个重写{@link Handler#handleMessage(Message)}的{@link Handler}
   * 来实现接收来自远程Service的消息。
   * 发送者Messenger在Activity调用绑定Service方法中
   * ServiceConnection实例的重写方法{@link ServiceConnection#onServiceConnected(ComponentName, IBinder)}里，
   * 通过绑定参数IBinder新建发送者Messenger对象，并使得在Activity中需要发送的消息{@link Message}中的
   * {@link Message#replyTo}参数被赋值接收者Messenger。最后使用发送者Messenger发送该Message消息。
   * 而且我们在Service中也有Messenger实例，其中绑定的Handler接收Message事件时，
   * 使用参数msg的replyTo成员变量，进行发送新的消息，从而又实现了Service向Activity通信。
   * 此处则是由Activity的接收者Messenger来处理消息。
   *
   * 实质上是一对Messenger在执行单向通信，而Service的Messenger既充当了接收者，又扮演了发送者角色。
   * Activity向Service发送的消息Message里，就告诉了Service，它需要回应的Messenger是谁。
   * （这个谁就是上述的接收者Messenger）
   */
  private void communicateWithMessenger(){
    receiverMessenger = new Messenger(new Handler(msg -> {
      Log.d(TAG, "Received data from remote service: msg.obj = " + msg.obj.toString());
      return false;
    }));
    serviceConnectionWithMessenger = new ServiceConnection() {
      @Override
      public void onServiceConnected(ComponentName name, IBinder iBinder) {
        senderMessenger = new Messenger(iBinder);
        Message message = new Message();
        message.replyTo = receiverMessenger;
        message.obj = "From remote activity";
        try {
          senderMessenger.send(message);
        } catch (RemoteException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onServiceDisconnected(ComponentName name) {

      }
    };
  }

  /**
   * 方法四：
   * 在src目录新建aidl目录，编写新的aidl文件。aidl文件的内容与interface写法相近。
   * 编译一次项目后，在远程Service中，使用该aidl接口IRemoteService的Stub抽象类，生成匿名类实例，完成接口方法的实现。
   * 并且我们在{@link android.app.Service#onBind(Intent)}重写方法中，返回该匿名类实例。
   * 在Activity中，我们只需在绑定的{@link ServiceConnection#onServiceConnected(ComponentName, IBinder)}重写方法里，
   * 调用IRemoteService.Stub.asInterface(IBinder)，传入IBinder实例，返回接口实例，即可直接调用其中的方法进行通信。
   */
  private void communicateViaAIDL(){
    remoteServiceConnection = new ServiceConnection() {
      @Override
      public void onServiceConnected(ComponentName name, IBinder service) {
        iSomeRemoteService = ISomeRemoteService.Stub.asInterface(service);
        try {
          String received = iSomeRemoteService.sendString("a string from remote activity");
          Log.d(TAG, "The string from remote service: s = " + received);
        } catch (RemoteException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onServiceDisconnected(ComponentName name) {

      }
    };
  }

  @Override
  public void onClick(View v) {
    try {
      switch (v.getId()) {
        case R.id.btn_bind_service:
          bindService(ServiceAction.INTERCOMMUNICATION, directServiceConnection);
          break;
        case R.id.btn_unbind_service:
          unbindService(directServiceConnection);
          progressBar.setProgress(0);
          tvProgress.setText("0%");
          break;
        case R.id.btn_start_downloading:
          service.startDownloadingDirectly();
          break;
        case R.id.btn_stop_downloading:
          service.stopDownloading();
          break;
        case R.id.btn_start_service_to_download:
//          startService(ServiceAction.INTERCOMMUNICATION);
          startService(new Intent(this, IntercommunicationService.class));
          break;
        case R.id.btn_stop_service:
//          stopService(ServiceAction.INTERCOMMUNICATION);
          stopService(new Intent(this, IntercommunicationService.class));
          break;
        case R.id.btn_bind_messenger_service:
          bindService(ServiceAction.MESSENGER_INTERCOMMUNICATION, serviceConnectionWithMessenger);
          break;
        case R.id.btn_unbind_messenger_service:
          unbindService(serviceConnectionWithMessenger);
          break;
        case R.id.btn_bind_remote_service:
          bindService(ServiceAction.SOME_REMOTE_SERVICE, remoteServiceConnection);
          break;
        case R.id.btn_unbind_remote_service:
          unbindService(remoteServiceConnection);
          break;
      }
    } catch (Exception e) {
      ToastUtil.makeText(this, e.getMessage());
    }
  }

  @Override
  protected void onDestroy() {
    try {
      unbindService(directServiceConnection);
      unregisterReceiver(receiver);
    }catch (Exception ignored){

    }
    super.onDestroy();
  }

  @Override
  public void onUpdateProgress(int progress) {
    progressBar.setProgress(progress);
    tvProgress.setText(String.format(
            getString(R.string.intercommunication_format_percentage), progress / 100.0));
  }

}
