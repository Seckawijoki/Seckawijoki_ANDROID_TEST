package com.seckawijoki.jnilibrary;

/**
 * Created by Seckawijoki on 2018/6/7 at 17:39 under Windows10 Professional.
 */
public class NativeCalculators {
  static {
    System.loadLibrary("nativecalculators-lib");
  }
  public static native int add(int a, int b);
}
