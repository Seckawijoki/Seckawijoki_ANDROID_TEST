package com.seckawijoki.android_test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.constant.ServerPath;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/4/25 at 23:19.
 */

public class SocketProgrammingActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socket_programming_activity);
        init();
    }

    private void init() {
        try {
            Socket client = new Socket(ServerPath.PATH, ServerPath.PORT);
            client.setSoTimeout(10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
