package com.seckawijoki.androidtest.widget;

import android.content.Context;
import android.support.annotation.Keep;
import android.util.AttributeSet;

/**
 * Created by seckawijoki on 18-5-2 at 下午6:01.
 */
public class MyTestView extends android.support.v7.widget.AppCompatButton{
    public MyTestView(Context context) {
        super(context);
    }

    public MyTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Keep
    public void setIntegerText(int i){
        setText(i+"");
    }

}
