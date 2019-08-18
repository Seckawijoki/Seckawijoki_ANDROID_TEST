package com.seckawijoki.androidtest.design_pattern.command;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Seckawijoki on 2019/8/17 at 23:27 under Windows-10 Professional.
 */
public class DrawPath implements IDraw {
  public Paint mPaint;
  public Path mPath;
  @Override
  public void draw(Canvas canvas) {
    canvas.drawPath(mPath, mPaint);
  }

  @Override
  public void undo() {

  }
}
