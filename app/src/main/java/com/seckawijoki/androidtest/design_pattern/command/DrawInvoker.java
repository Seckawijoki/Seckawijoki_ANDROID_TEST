package com.seckawijoki.androidtest.design_pattern.command;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Seckawijoki on 2019/8/17 at 23:28 under Windows-10 Professional.
 */
public class DrawInvoker {
    private List<DrawPath> mDrawPathList = Collections.synchronizedList(new ArrayList<DrawPath>());
    private List<DrawPath> mRedoList = Collections.synchronizedList(new ArrayList<DrawPath>());

    public void add(DrawPath drawPath) {
        mRedoList.clear();
        mDrawPathList.add(drawPath);
    }

    public void undo() {
        if ( mDrawPathList != null && mDrawPathList.size() > 0 ) {
            DrawPath undo = mDrawPathList.get(mDrawPathList.size() - 1);
            mDrawPathList.remove(mDrawPathList.size() - 1);
            undo.undo();
            mRedoList.add(undo);
        }
    }

    public void redo() {
        if ( mRedoList != null && mRedoList.size() > 0 ) {
            DrawPath redo = mRedoList.get(mRedoList.size() - 1);
            mRedoList.remove(mRedoList.size() - 1);
            mDrawPathList.add(redo);
        }
    }

    public void execute(Canvas canvas) {
        for ( DrawPath drawPath : mDrawPathList ) {
            drawPath.draw(canvas);
        }
    }

    public boolean canRedo(){
        return mRedoList != null && mRedoList.size() > 0;
    }

    public boolean canUndo(){
        return mDrawPathList != null && mDrawPathList.size() > 0;
    }
}
