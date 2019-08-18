package com.seckawijoki.androidtest.util;
import android.app.Activity;
import android.view.View;
/**
 * Created by Seckawijoki on 2019/8/18 at 16:40 under Windows-10 Professional.
 */
public class ViewUtil {
    private ViewUtil(){}
    public static void bindOnClickListener(Activity activity, View.OnClickListener onClickListener, int ...ids){
        for ( int id : ids ) {
            activity.findViewById(id).setOnClickListener(onClickListener);
        }
    }
}
