package com.seckawijoki.android_test.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/4 at 23:17.
 */

public class WhetherContentProvider extends ContentProvider {
  private static final String TAG = "WhetherContentProvider";

  public WhetherContentProvider() {
  }

  @Override
  public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
    return -1;
  }

  @Override
  public String getType(@NonNull Uri uri) {
    return "plain/text";
  }

  @Override
  public Uri insert(@NonNull Uri uri, ContentValues values) {
    return null;
  }

  @Override
  public boolean onCreate() {
    return true;
  }

  @Override
  public Cursor query(@NonNull Uri uri, String[] projection, String selection,
                      String[] selectionArgs, String sortOrder) {
    Log.i(TAG, "query: Thread ID = " + Thread.currentThread().getId());
    return null;
  }

  @Override
  public int update(@NonNull Uri uri, ContentValues values, String selection,
                    String[] selectionArgs) {
    return -1;
  }
}
