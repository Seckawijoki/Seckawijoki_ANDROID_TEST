package com.seckawijoki.android_test.binder;

import android.app.Service;
import android.os.Binder;

/**
 * Created by seckawijoki on 2018-05-22 at 17:59 under Ubuntu-16.04 LTS.
 */
public class IntercommunicationBinder extends Binder {
  private Service service;
  public IntercommunicationBinder(Service service) {
    this.service = service;
  }
  public Service getService() {
    return service;
  }
}
