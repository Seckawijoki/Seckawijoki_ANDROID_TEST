package com.seckawijoki.androidtest.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 瑶琴频曲羽衣魂 on 2017/6/22.
 */

public class ToastUtil {
  private static Toast toast;
  private ToastUtil(){}
  public static void makeText(Context context, String string){
    if (toast != null) {
      toast.setText(string);
    } else {
      toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
    }
    toast.show();
  }
  public static void makeText(Context context, int res){
    if (toast != null) {
      toast.setText(res);
    } else {
      toast = Toast.makeText(context, res, Toast.LENGTH_SHORT);
    }
    toast.show();
  }
}
