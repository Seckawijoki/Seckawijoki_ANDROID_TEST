package org.appplay.lib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.appplay.lib.MobileNetworkUtil.getNetworkClass;
/**
 * Created by Seckawijoki on 2018/7/21 at 15:38 under Windows10 Professional.
 */
public class AppPlayNetworkMonitor {
  private static final String TAG = "AppPlayNetworkMonitor";
  private Context mContext;
  private ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
  private static final int INTERVAL = 3;
  public AppPlayNetworkMonitor(Context context) {
    this.mContext = context;
    AppPlayNetworkObserver.registerCallback(mCallback);
    pool.scheduleAtFixedRate(mRunnable, 0, INTERVAL, TimeUnit.SECONDS);
  }
  private void nativeMonitor() {
    ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
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

  private AppPlayNetworkObserver.Callback mCallback = new AppPlayNetworkObserver.Callback() {
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
  };
  private Runnable mRunnable = new Runnable() {
    @Override
    public void run() {
      nativeMonitor();
//    monitorByNetworkStateUtils();
//    nativeMonitorByNetworkInfoState();
//    monitorByActiveNetworkInfo();
    }
  };
}

