package org.appplay.lib;

import java.util.Vector;

/**
 * Created by Seckawijoki on 2018/7/21 at 16:05 under Windows10 Professional.
 */
public class AppPlayNetworkObserver {
  private static Vector<Callback> msCallbackList = new Vector<>();
  public interface Callback{
    void onWifi();
    void onMobileNetwork();
    void on2G();
    void on3G();
    void on4G();
    void onNetworkDisabled();
  }

  public static void registerCallback(Callback callback){
    if ( !msCallbackList.contains(callback) )
      msCallbackList.add(callback);
  }
  public static void unregisterCallback(Callback callback){
    if ( msCallbackList.contains(callback) )
      msCallbackList.remove(callback);
  }
  public static void unregisterAll(){
    if ( msCallbackList != null ) {
      msCallbackList.removeAllElements();
    }
  }

  @Deprecated
  public static void onNetworkCallback(int networkCallbackType){
    for ( Callback callback : msCallbackList ) {
      switch ( networkCallbackType ){
        case NetworkCallbackType.WIFI:
          callback.onWifi();
          break;
        case NetworkCallbackType.MOBILE:
          callback.onMobileNetwork();
          break;
        case NetworkCallbackType._2G:
          callback.on2G();
          break;
        case NetworkCallbackType._3G:
          callback.on3G();
          break;
        case NetworkCallbackType._4G:
          callback.on4G();
          break;
        case NetworkCallbackType.DISABLED:
          callback.onNetworkDisabled();
          break;
      }
    }
  }
}
