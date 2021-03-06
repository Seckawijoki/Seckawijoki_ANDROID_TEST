package com.seckawijoki.androidtest.annotation;

import com.seckawijoki.androidtest.constant.FruitColorType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/31 at 15:03 under Windows-10 Professional.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
  FruitColorType value() default FruitColorType.GREEN;
}
