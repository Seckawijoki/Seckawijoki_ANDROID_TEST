package com.seckawijoki.androidtest.design_pattern.command;

import android.graphics.Path;

/**
 * Created by Seckawijoki on 2019/8/17 at 23:08 under Windows-10 Professional.
 */
public class NormalBrush implements IBrush {
  @Override
  public void down(Path path, float x, float y) {
    path.moveTo(x, y);
  }

  @Override
  public void move(Path path, float x, float y) {
    path.lineTo(x, y);
  }

  @Override
  public void up(Path path, float x, float y) {

  }
}
