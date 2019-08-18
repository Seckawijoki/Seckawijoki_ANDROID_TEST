package com.seckawijoki.androidtest.design_pattern.command;

import android.graphics.Path;

/**
 * Created by Seckawijoki on 2019/8/17 at 23:08 under Windows-10 Professional.
 */
public class CircleBrush implements IBrush {
  @Override
  public void down(Path path, float x, float y) {

  }

  @Override
  public void move(Path path, float x, float y) {
    path.addCircle(x, y, 10, Path.Direction.CW);
  }

  @Override
  public void up(Path path, float x, float y) {

  }
}
