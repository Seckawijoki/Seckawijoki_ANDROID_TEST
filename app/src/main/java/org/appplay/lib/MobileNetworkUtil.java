package org.appplay.lib;

import android.net.NetworkInfo;

import static android.telephony.TelephonyManager.*;

/**
 * Created by Seckawijoki on 2018/7/23 at 14:12 under Windows10 Professional.
 */
public class MobileNetworkUtil {
  public static final int NETWORK_CLASS_UNKNOWN=0;
  public static final int NETWORK_CLASS_2_G=1;
  public static final int NETWORK_CLASS_3_G=2;
  public static final int NETWORK_CLASS_4_G=3;
  public static int getNetworkClass(NetworkInfo activeNetworkInfo){
    return getNetworkClass(activeNetworkInfo.getSubtype());
  }
  public static int getNetworkClass(int networkType) {
    switch (networkType) {
      case NETWORK_TYPE_GPRS:
      case NETWORK_TYPE_EDGE:
      case NETWORK_TYPE_CDMA:
      case NETWORK_TYPE_1xRTT:
      case NETWORK_TYPE_IDEN:
        return NETWORK_CLASS_2_G;
      case NETWORK_TYPE_UMTS:
      case NETWORK_TYPE_EVDO_0:
      case NETWORK_TYPE_EVDO_A:
      case NETWORK_TYPE_HSDPA:
      case NETWORK_TYPE_HSUPA:
      case NETWORK_TYPE_HSPA:
      case NETWORK_TYPE_EVDO_B:
      case NETWORK_TYPE_EHRPD:
      case NETWORK_TYPE_HSPAP:
        return NETWORK_CLASS_3_G;
      case NETWORK_TYPE_LTE:
        return NETWORK_CLASS_4_G;
      default:
        return NETWORK_CLASS_UNKNOWN;
    }
  }
}
