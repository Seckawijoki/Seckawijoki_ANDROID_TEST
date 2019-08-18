package com.seckawijoki.androidtest.design_pattern.command;

import android.graphics.Path;

/**
 * Created by Seckawijoki on 2019/8/17 at 23:07 under Windows-10 Professional.
 * 策略
 */
public interface IBrush {
  void down(Path path, float x, float y);
  void move(Path path, float x, float y);
  void up(Path path, float x, float y);
}
