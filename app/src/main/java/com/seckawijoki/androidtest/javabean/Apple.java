package com.seckawijoki.androidtest.javabean;

import com.seckawijoki.androidtest.annotation.FruitColor;
import com.seckawijoki.androidtest.annotation.FruitName;
import com.seckawijoki.androidtest.constant.FruitColorType;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/31 at 15:05 under Windows-10 Professional.
 */
public class Apple {
  @FruitName("Apple")
  private String appleName;
  @FruitColor(FruitColorType.RED)
  private FruitColorType appleColor;
  public String getAppleName() {
    return appleName;
  }
  public Apple setAppleName(String appleName) {
    this.appleName = appleName;
    return this;
  }
  public FruitColorType getAppleColor() {
    return appleColor;
  }
  public Apple setAppleColor(FruitColorType appleColor) {
    this.appleColor = appleColor;
    return this;
  }
}
