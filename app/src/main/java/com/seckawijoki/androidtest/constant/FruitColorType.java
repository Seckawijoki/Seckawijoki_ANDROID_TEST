package com.seckawijoki.androidtest.constant;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/31 at 15:13 under Windows-10 Professional.
 */
public enum FruitColorType {
  RED("red"),
  GREEN("green"),
  BLUE("blue");
  private String str;

  FruitColorType(String s) {
    this.str = s;
  }

  @Override
  public String toString() {
    return str;
  }
}
