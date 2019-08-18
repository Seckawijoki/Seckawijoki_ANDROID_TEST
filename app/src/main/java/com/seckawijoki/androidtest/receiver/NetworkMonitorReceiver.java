package com.seckawijoki.androidtest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by Seckawijoki on 2018/7/17 at 17:48 under Windows10 Professional.
 */
public class NetworkMonitorReceiver extends BroadcastReceiver {
  private static final String TAG = "NetworkMonitorReceiver";

  public NetworkMonitorReceiver() {
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    // 这个监听wifi的打开与关闭，与wifi的连接无关
    if ( WifiManager.WIFI_STATE_CHANGED_ACTION.equals(intent.getAction()) ) {
      Log.i(TAG, "onReceive(): WifiManager.WIFI_STATE_CHANGED_ACTION");
      int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
      Log.d(TAG, "onReceive(): wifiState = " + wifiState);
      switch ( wifiState ) {
        case WifiManager.WIFI_STATE_DISABLING:
          Log.i(TAG, "onReceive(): WIFI_STATE_DISABLING");
          break;
        case WifiManager.WIFI_STATE_DISABLED:
          Log.i(TAG, "onReceive(): WIFI_STATE_DISABLE");
          break;
        case WifiManager.WIFI_STATE_ENABLING:
          Log.i(TAG, "onReceive(): WIFI_STATE_ENABLING");
          break;
        case WifiManager.WIFI_STATE_ENABLED:
          Log.i(TAG, "onReceive(): WIFI_STATE_ENABLED");
          break;
        case WifiManager.WIFI_STATE_UNKNOWN:
          Log.i(TAG, "onReceive(): WIFI_STATE_UNKNOWN");
          break;
      }
    }
    // 这个监听wifi的连接状态即是否连上了一个有效无线路由，当上边广播的状态是WifiManager
    // .WIFI_STATE_DISABLING，和WIFI_STATE_DISABLED的时候，根本不会接到这个广播。
    // 在上边广播接到广播是WifiManager.WIFI_STATE_ENABLED状态的同时也会接到这个广播，
    // 当然刚打开wifi肯定还没有连接到有效的无线
    if ( WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction()) ) {
      Log.i(TAG, "onReceive(): WifiManager.NETWORK_STATE_CHANGED_ACTION");
      Parcelable parcelableExtra = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
      if ( parcelableExtra != null ) {
        NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
        State state = networkInfo.getState();
        boolean connected = state == State.CONNECTED;
        Log.d(TAG, "onReceive(): connected = " + connected);
      }
    }
    // 这个监听网络连接的设置，包括wifi和移动数据的打开和关闭。.
    // 最好用的还是这个监听。wifi如果打开，关闭，以及连接上可用的连接都会接到监听。见log
    // 这个广播的最大弊端是比上边两个广播的反应要慢，如果只是要监听wifi，我觉得还是用上边两个配合比较合适
    if ( ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()) ) {
      Log.i(TAG, "onReceive(): ConnectivityManager.CONNECTIVITY_ACTION");
      ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
      NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
      if ( activeNetwork != null ) {
        if ( activeNetwork.isConnected() ) {
          if ( activeNetwork.getType() == ConnectivityManager.TYPE_WIFI ) {
            Log.i(TAG, "onReceive(): 当前WiFi连接可用");
          } else if ( activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE ) {
            Log.i(TAG, "onReceive(): 当前移动网络可用");
          }
        } else {
          Log.i(TAG, "onReceive(): 当前没有网络连接，请确保你已经打开网络");
        }

        Log.d(TAG, "onReceive(): activeNetwork.getTypeName() = " + activeNetwork.getTypeName());
        Log.d(TAG, "onReceive(): activeNetwork.getSubtypeName() = " + activeNetwork.getSubtypeName());
        Log.d(TAG, "onReceive(): activeNetwork.getState() = " + activeNetwork.getState());
        Log.d(TAG, "onReceive(): activeNetwork.getExtraInfo() = " + activeNetwork.getExtraInfo());
        Log.d(TAG, "onReceive(): activeNetwork.getType() = " + activeNetwork.getType());
      } else {
        Log.i(TAG, "onReceive(): 当前没有网络连接，请确保你已经打开网络");

      }
    }
  }
}
