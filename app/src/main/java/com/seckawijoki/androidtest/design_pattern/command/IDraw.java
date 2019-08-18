package com.seckawijoki.androidtest.design_pattern.command;

import android.graphics.Canvas;

/**
 * Created by Seckawijoki on 2019/8/17 at 23:26 under Windows-10 Professional.
 * 命令接口。具体保存主语和宾语。
 */
public interface IDraw {
  void draw(Canvas canvas);
  void undo();
}
