package org.appplay.lib;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.seckawijoki.androidtest.util.NetworkStateUtils;

import static org.appplay.lib.MobileNetworkUtil.getNetworkClass;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Seckawijoki on 2018/7/21 at 15:38 under Windows10 Professional.
 */
public class NetworkMonitorService extends Service implements Runnable, AppPlayNetworkObserver.Callback {
  private static final String TAG = "NetworkMonitorService";
  private ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
  private static final int INTERVAL = 3;
//  private NetworkMonitorReceiver mReceiver;
  private ConnectivityManager mConnectivityManager;

  @Override
  public void onCreate() {
    Log.i(TAG, "onCreate(): ");
    super.onCreate();
//    mReceiver = new NetworkMonitorReceiver();
    AppPlayNetworkObserver.registerCallback(this);
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.i(TAG, "onStartCommand(): ");
//    IntentFilter intentFilter = new IntentFilter(ReceiverAction.NETWORK_MONITOR);
//    registerReceiver(mReceiver, intentFilter);
    pool.scheduleAtFixedRate(this, 0, INTERVAL, TimeUnit.SECONDS);
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public void run() {
    nativeMonitor();
//    monitorByNetworkStateUtils();
//    nativeMonitorByNetworkInfoState();
//    monitorByActiveNetworkInfo();
  }

  private void nativeMonitor() {
    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    int networkCallbackType = NetworkCallbackType.UNKNOWN;
    if ( activeNetworkInfo != null && activeNetworkInfo.isConnected() ) {
      if ( activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI ) {
        //Wifi网络
        networkCallbackType = NetworkCallbackType.WIFI;
      } else if ( activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE ) {
        //移动网络
        switch ( getNetworkClass(activeNetworkInfo) ){
          case MobileNetworkUtil.NETWORK_CLASS_4_G:
            networkCallbackType = NetworkCallbackType._4G;
            break;
          case MobileNetworkUtil.NETWORK_CLASS_3_G:
            networkCallbackType = NetworkCallbackType._3G;
            break;
          case MobileNetworkUtil.NETWORK_CLASS_2_G:
            networkCallbackType = NetworkCallbackType._2G;
            break;
          default:
            networkCallbackType = NetworkCallbackType.MOBILE;
            break;
        }
      }
    } else {
      networkCallbackType = NetworkCallbackType.DISABLED;
    }
    AppPlayNatives.nativeOnNetwork(networkCallbackType);
  }

  @Deprecated
  private void monitorByNetworkStateUtils() {
    if ( NetworkStateUtils.isWifi(this) ) Log.i(TAG, "monitorByNetworkStateUtils0(): isWifi()");
    if ( NetworkStateUtils.isMobileConnected(this) )
      Log.i(TAG, "monitorByNetworkStateUtils0(): isMobileConnected()");
    if ( NetworkStateUtils.isNetworkConnected(this) )
      Log.i(TAG, "monitorByNetworkStateUtils0(): inNetworkConnected()");
    if ( NetworkStateUtils.is2G(this) ) Log.i(TAG, "monitorByNetworkStateUtils0(): is2G()");
    if ( NetworkStateUtils.is3G(this) ) Log.i(TAG, "monitorByNetworkStateUtils0(): is3G()");
    if ( NetworkStateUtils.isGPSEnabled(this) )
      Log.i(TAG, "monitorByNetworkStateUtils0(): isGPSEnabled()");
    if ( NetworkStateUtils.isWifiEnabled(this) )
      Log.i(TAG, "monitorByNetworkStateUtils0(): isWifiEnabled()");
  }

  @Deprecated
  private void nativeMonitorByNetworkInfoState() {
    State wifiState;
    State mobileState;
    try {
      mConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
      wifiState = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
      mobileState = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
      if ( mobileState != null && mobileState == State.CONNECTED ) {
        AppPlayNatives.nativeOnNetwork(NetworkCallbackType.WIFI);
      } else if ( wifiState != null && wifiState == State.CONNECTED ) {
        AppPlayNatives.nativeOnNetwork(NetworkCallbackType.MOBILE);
      } else if ( wifiState != null && mobileState != null
              && wifiState != State.CONNECTED && mobileState != State.CONNECTED ) {
        AppPlayNatives.nativeOnNetwork(NetworkCallbackType.DISABLED);
      }
    } catch ( NullPointerException ignored ) {
    }
  }

  @Deprecated
  private void monitorByActiveNetworkInfo() {
    mConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
    if ( activeNetworkInfo != null ) {
      if ( activeNetworkInfo.isConnected() ) {
        if ( activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI ) {
          Log.i(TAG, "monitorByActiveNetworkInfo(): 当前WiFi连接可用");
        } else if ( activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE ) {
          Log.i(TAG, "monitorByActiveNetworkInfo(): 当前移动网络连接可用");
        }
      } else {
        Log.i(TAG, "monitorByActiveNetworkInfo(): 当前没有网络连接，请确保你已经打开网络");
      }
    } else {
      Log.i(TAG, "monitorByActiveNetworkInfo(): 当前没有网络连接，请确保你已经打开网络");
    }
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
//    unregisterReceiver(mReceiver);
    AppPlayNetworkObserver.unregisterCallback(this);
  }

  @Nullable
  @Override
  @Deprecated
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onNetworkDisabled() {
    Log.i(TAG, "onNetworkDisabled(): 当前没有网络连接");
  }

  @Override
  public void onWifi() {
    Log.i(TAG, "onWifi(): 当前WiFi连接");
  }

  @Override
  public void onMobileNetwork() {
    Log.i(TAG, "onMobileNetwork(): 当前移动网络连接");
  }

  @Override
  public void on2G() {
    Log.i(TAG, "on2G(): ");
  }

  @Override
  public void on3G() {
    Log.i(TAG, "on3G(): ");
  }

  @Override
  public void on4G() {
    Log.i(TAG, "on4G()");
  }

}

