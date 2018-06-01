package com.seckawijoki.androidtest.activity;
/**
 * Created by seckawijoki on 18-5-2 at 下午10:32.
 */

import com.seckawijoki.androidtest.base.AbsLaunchModeActivity;

public class SingleInstanceLaunchModeActivity extends AbsLaunchModeActivity {
    @Override
    public String setTag() {
        return "SingleInstanceActivity";
    }


}