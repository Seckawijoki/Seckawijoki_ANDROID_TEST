package com.seckawijoki.android_test.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by seckawijoki on 18-5-5 at 上午10:20.
 */
public abstract class AbsActivity extends AppCompatActivity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(setLayout());
    initView();
  }

  public final void startActivity(String intentAction) {
    startActivity(new Intent(intentAction));
  }

  public final void startService(String serviceAction){
    Intent intent = new Intent(serviceAction);
    Intent eIntent = new Intent(createExplicitFromImplicitIntent(this, intent));
    startService(eIntent);
  }
  public final void stopService(String serviceAction){
    Intent intent = new Intent(serviceAction);
    Intent eIntent = new Intent(createExplicitFromImplicitIntent(this, intent));
    stopService(eIntent);
  }

  public final void bindService(String serviceAction, ServiceConnection serviceConnection) {
    Intent intent = new Intent(serviceAction);
    Intent eIntent = new Intent(createExplicitFromImplicitIntent(this, intent));
    bindService(eIntent, serviceConnection, BIND_AUTO_CREATE);
  }

  @LayoutRes
  public abstract int setLayout();

  protected abstract void initView();

  /***
   * Android L (lollipop, API 21) introduced a new problem when trying to invoke implicit intent,
   * "java.lang.IllegalArgumentException: Service Intent must be explicit"
   *
   * If you are using an implicit intent, and know only 1 target would answer this intent,
   * This method will help you turn the implicit intent into the explicit form.
   *
   * Inspired from SO answer: http://stackoverflow.com/a/26318757/1446466
   * @param context context
   * @param implicitIntent - The original implicit intent
   * @return Explicit Intent created from the implicit original intent
   */
  public static Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
    // Retrieve all services that can match the given intent
    PackageManager pm = context.getPackageManager();
    List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

    // Make sure only one match was found
    if (resolveInfo == null || resolveInfo.size() != 1) {
      return null;
    }
    // Get component info and create ComponentName
    ResolveInfo serviceInfo = resolveInfo.get(0);
    String packageName = serviceInfo.serviceInfo.packageName;
    String className = serviceInfo.serviceInfo.name;
    ComponentName component = new ComponentName(packageName, className);

    // Create a new intent. Use the old one for extras and such reuse
    Intent explicitIntent = new Intent(implicitIntent);

    // Set the component to be explicit
    explicitIntent.setComponent(component);

    return explicitIntent;
  }
}
