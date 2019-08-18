package com.seckawijoki.androidtest.design_pattern.command;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/**
 * Created by Seckawijoki on 2019/8/18 at 15:37 under Windows-10 Professional.
 */
public class DrawCanvas extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "DrawCanvas";
    public boolean isDrawing, isRunning;
    private Bitmap mBitmap;
    private DrawInvoker mDrawInvoker;
    private DrawThread mDrawThread;

    public DrawCanvas(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mDrawInvoker = new DrawInvoker();
        mDrawThread = new DrawThread();

        getHolder().addCallback(this);
    }

    public void add(DrawPath drawPath){
        mDrawInvoker.add(drawPath);
    }

    public void redo(){
        isDrawing = true;
        mDrawInvoker.redo();
    }

    public void undo(){
        isDrawing = true;
        mDrawInvoker.undo();
    }

    public boolean canUndo(){
        return mDrawInvoker.canUndo();
    }

    public boolean canRedo(){
        return mDrawInvoker.canRedo();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isRunning = true;
        mDrawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        isRunning = false;
        while ( retry ){
            try {
                Log.i(TAG, "surfaceDestroyed(): join before: " + System.currentTimeMillis());
                mDrawThread.join();
                Log.i(TAG, "surfaceDestroyed(): join after: " + System.currentTimeMillis());
                retry = false;
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

    private class DrawThread extends Thread {

        @Override
        public void run() {
            Canvas canvas = null;
            while ( isRunning ){
                if (isDrawing){
                    try {
                        canvas = getHolder().lockCanvas(null);
                        if ( mBitmap == null ) {
                            mBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                        }
                        Canvas c = new Canvas(mBitmap);
                        c.drawColor(0, PorterDuff.Mode.CLEAR);
                        mDrawInvoker.execute(c);
                        canvas.drawBitmap(mBitmap, 0, 0,null);
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    } finally {
                        getHolder().unlockCanvasAndPost(canvas);
                    }
                    isDrawing = false;
                }
            }
        }
    }
}
