package com.seckawijoki.androidtest.design_pattern.command;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ViewUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.util.ViewUtil;
/**
 * Created by Seckawijoki on 2019/8/18 at 15:48 under Windows-10 Professional.
 */
public class DrawActivity extends Activity implements View.OnClickListener {
    private DrawCanvas mDrawCanvas;
    private DrawPath mDrawPath;
    private Paint mPaint;
    private IBrush mBrush;

    private Button btnRedo;
    private Button btnUndo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_pattern_command_draw_activity);

        mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.WHITE);
        mBrush = new NormalBrush();

        mDrawCanvas = (DrawCanvas) findViewById(R.id.design_pattern_command_draw_canvas);
        btnRedo = (Button) findViewById(R.id.design_pattern_command_draw_btn_redo);
        btnUndo = findViewById(R.id.design_pattern_command_draw_btn_undo);

        mDrawCanvas.setOnTouchListener(new DrawTouchListener());
        btnRedo.setEnabled(false);
        btnUndo.setEnabled(false);

        ViewUtil.bindOnClickListener(this, this,
                R.id.design_pattern_command_draw_btn_blue,
                R.id.design_pattern_command_draw_btn_red,
                R.id.design_pattern_command_draw_btn_green,
                R.id.design_pattern_command_draw_btn_redo,
                R.id.design_pattern_command_draw_btn_undo,
                R.id.design_pattern_command_draw_btn_normal_brush,
                R.id.design_pattern_command_draw_btn_circle_brush
        );
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ) {
            case R.id.design_pattern_command_draw_btn_blue:
                mPaint = new Paint();
                mPaint.setColor(Color.BLUE);
                mPaint.setStrokeWidth(3);
                break;
            case R.id.design_pattern_command_draw_btn_green:
                mPaint = new Paint();
                mPaint.setColor(Color.GREEN);
                mPaint.setStrokeWidth(3);
                break;
            case R.id.design_pattern_command_draw_btn_red:
                mPaint = new Paint();
                mPaint.setColor(Color.RED);
                mPaint.setStrokeWidth(3);
                break;
            case R.id.design_pattern_command_draw_btn_circle_brush:
                mBrush = new CircleBrush();
                break;
            case R.id.design_pattern_command_draw_btn_normal_brush:
                mBrush = new NormalBrush();
                break;
            case R.id.design_pattern_command_draw_btn_redo:
                mDrawCanvas.redo();
                btnRedo.setEnabled(mDrawCanvas.canRedo());
                break;
            case R.id.design_pattern_command_draw_btn_undo:
                mDrawCanvas.undo();
                btnUndo.setEnabled(mDrawCanvas.canUndo());
                break;
        }
    }

    private class DrawTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if ( event.getAction() == MotionEvent.ACTION_DOWN ) {
                mDrawPath = new DrawPath();
                mDrawPath.mPaint = mPaint;
                mDrawPath.mPath = new Path();
                mBrush.down(mDrawPath.mPath, event.getX(), event.getY());
            } else if ( event.getAction() == MotionEvent.ACTION_MOVE ) {
                mBrush.move(mDrawPath.mPath, event.getX(), event.getY());
            } else if ( event.getAction() == MotionEvent.ACTION_UP ) {
                mBrush.up(mDrawPath.mPath, event.getX(), event.getY());
                mDrawCanvas.add(mDrawPath);
                mDrawCanvas.isDrawing = true;
                btnRedo.setEnabled(true);
                btnUndo.setEnabled(true);
            }
            return true;
        }
    }
}
