package com.seckawijoki.android_test.activity;
/**
 * Created by seckawijoki on 18-5-2 at 下午10:32.
 */

import com.seckawijoki.android_test.base.AbsLaunchModeActivity;

public class SingleInstanceLaunchModeActivity extends AbsLaunchModeActivity {
    @Override
    public String setTag() {
        return "SingleInstanceActivity";
    }


}