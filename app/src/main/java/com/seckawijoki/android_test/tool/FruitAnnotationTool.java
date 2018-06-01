package com.seckawijoki.android_test.tool;

import android.util.Log;

import com.seckawijoki.android_test.annotation.FruitColor;
import com.seckawijoki.android_test.annotation.FruitName;
import com.seckawijoki.android_test.constant.FruitColorType;

import java.lang.reflect.Field;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/31 at 15:11 under Windows-10 Professional.
 */
public class FruitAnnotationTool {
  private static final String TAG = "FruitAnnotationTool";
  public static void getInfo(Class<?> clazz){
    String name;
    FruitColorType color;
    Field[] fields = clazz.getDeclaredFields();
    for ( Field field : fields ) {
      if (field.isAnnotationPresent(FruitName.class)){
        FruitName fruitName = field.getAnnotation(FruitName.class);
        name = fruitName.value();
        Log.d(TAG, "getInfo()\n: fruitName = " + fruitName);
      }
      if (field.isAnnotationPresent(FruitColor.class)){
        FruitColor fruitColor = field.getAnnotation(FruitColor.class);
        color = fruitColor.value();
        Log.d(TAG, "getInfo()\n: fruitColor = " + fruitColor);
      }
    }
  }
}
