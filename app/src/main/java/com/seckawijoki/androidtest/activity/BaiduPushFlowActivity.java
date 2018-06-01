package com.seckawijoki.androidtest.activity;

import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceView;

import com.baidu.recorder.api.LiveConfig;
import com.baidu.recorder.api.LiveSession;
import com.baidu.recorder.api.LiveSessionHW;
import com.baidu.recorder.api.LiveSessionSW;
import com.baidu.recorder.api.SessionStateListener;
import com.seckawijoki.androidtest.R;
import com.seckawijoki.androidtest.base.AbsActivity;

/**
 * Created by seckawijoki on 18-5-6 at 下午4:32.
 */
public class BaiduPushFlowActivity extends AbsActivity{
  private static final String TAG = "BaiduPushFlowActivity";
  private static final int EVENT_RECORDER_STARTED = 0;
  private static final int EVENT_RECORDER_STOPPED = 1;
  private static final int EVENT_RECORDER_UNKNOWN_ERROR = 2;
  private final String url1 = "rtmp://172.29.25.27/seckawijoki/";
  private LiveSession mLiveSession;
  private int mVideoWidth = 300;
  private int mVideoHeight = 600;
  private int orientation = 1;
  private int mFrameRate = 60;
  private int mBitrate = 9000;

  @Override
  public int setLayout() {
    return R.layout.baidu_push_flow_activity;
  }

  @Override
  protected void initView() {
    LiveConfig liveConfig = new LiveConfig.Builder()
            .setCameraId(LiveConfig.CAMERA_FACING_FRONT) // 选择摄像头为前置摄像头
            .setCameraOrientation(orientation) // 设置摄像头为竖向
            .setVideoWidth(mVideoWidth) // 设置推流视频宽度, 需传入长的一边
            .setVideoHeight(mVideoHeight) // 设置推流视频高度，需传入短的一边
            .setVideoFPS(mFrameRate) // 设置视频帧率
            .setInitVideoBitrate(mBitrate) // 设置视频码率，单位为bit per seconds
            .setAudioBitrate(64 * 1000) // 设置音频码率，单位为bit per seconds
            .setAudioSampleRate(LiveConfig.AUDIO_SAMPLE_RATE_44100) // 设置音频采样率
            .setGopLengthInSeconds(2) // 设置I帧间隔，单位为秒
            .setQosEnabled(true) // 开启码率自适应，默认为true，即默认开启
            .setMinVideoBitrate(200 * 1000) // 码率自适应，最低码率
            .setMaxVideoBitrate(1024 * 1000) // 码率自适应，最高码率
            .setQosSensitivity(5) // 码率自适应，调整的灵敏度，单位为秒，可接受[5, 10]之间的整数值
            .build();
    Log.d(TAG, "Calling initRTMPSession..." + liveConfig.toString());
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
      mLiveSession = new LiveSessionHW(this, liveConfig);
    } else {
      mLiveSession = new LiveSessionSW(this, liveConfig);
    }
    SurfaceView cameraView = (SurfaceView) findViewById(R.id.surface_view_baidu_push_flow);
    mLiveSession.bindPreviewDisplay(cameraView.getHolder());
    mLiveSession.prepareSessionAsync();
  }

  private void startStreaming(){
    if (mLiveSession.startRtmpSession(url1)) {
      Log.d(TAG, "Starting Streaming in right state!");
    } else {
      Log.e(TAG, "Starting Streaming in wrong state!");
    }
  }

  private void stopPreview(){
    mLiveSession.stopRtmpSession();
  }

  private boolean isSessionReady;
  private boolean isSessionStarted;
  private Handler mEventHandler;
  // 其中 mEventHandler 为各 UI 事件处理器
  private SessionStateListener mStateListener = new SessionStateListener() {
    @Override
    public void onSessionPrepared(int code) {
      if (code == SessionStateListener.RESULT_CODE_OF_OPERATION_SUCCEEDED) {
        isSessionReady = true;
      }
    }

    @Override
    public void onSessionStarted(int code) {
      if (code == SessionStateListener.RESULT_CODE_OF_OPERATION_SUCCEEDED) {
        Log.d(TAG, "Starting Streaming succeeded!");
        isSessionStarted = true;
        if (mEventHandler != null) {
          mEventHandler.sendEmptyMessage(EVENT_RECORDER_STARTED);
        }
      } else {
        Log.e(TAG, "Starting Streaming failed!");
      }
    }

    @Override
    public void onSessionStopped(int code) {
      if (code == SessionStateListener.RESULT_CODE_OF_OPERATION_SUCCEEDED) {
        Log.d(TAG, "Stopping Streaming succeeded!");
        isSessionStarted = false;
        if (mEventHandler != null) {
          mEventHandler.sendEmptyMessage(EVENT_RECORDER_STOPPED);
        }
      } else {
        Log.e(TAG, "Stopping Streaming failed!");
      }
    }

    @Override
    public void onSessionError(int code) {
      switch (code) {
        case SessionStateListener.ERROR_CODE_OF_OPEN_MIC_FAILED:
          Log.e(TAG, "Error occurred while opening MIC!");
          onOpenDeviceFailed();
          break;
        case SessionStateListener.ERROR_CODE_OF_OPEN_CAMERA_FAILED:
          Log.e(TAG, "Error occurred while opening Camera!");
          onOpenDeviceFailed();
          break;
        case SessionStateListener.ERROR_CODE_OF_PREPARE_SESSION_FAILED:
          Log.e(TAG, "Error occurred while preparing recorder!");
          onPrepareFailed();
          break;
        case SessionStateListener.ERROR_CODE_OF_CONNECT_TO_SERVER_FAILED:
          Log.e(TAG, "Error occurred while connecting to server!");
          // As we can not start session successfully, we need to take it as stopped
          onStartOrStopFailed();
          break;
        case SessionStateListener.ERROR_CODE_OF_DISCONNECT_FROM_SERVER_FAILED:
          Log.e(TAG, "Error occurred while disconnecting from server!");
          // Although we can not stop session successfully, we still need to take it as stopped
          onStartOrStopFailed();
          break;
        case SessionStateListener.ERROR_CODE_OF_WEAK_CONNECTION_ERROR:
          Log.e(TAG, "Your network connection is too weak to streaming!");
          onStreamingError();
          break;
        case SessionStateListener.ERROR_CODE_OF_SERVER_INTERNAL_ERROR:
          Log.e(TAG, "There is something wrong with the server!");
          onStreamingError();
          break;
        case SessionStateListener.ERROR_CODE_OF_LOCAL_NETWORK_ERROR:
          Log.e(TAG, "Connection Error while Streaming! Please check your network!");
          onStreamingError();
          break;
        default:
          if (mEventHandler != null) {
            mEventHandler.sendEmptyMessage(EVENT_RECORDER_UNKNOWN_ERROR);
            onStreamingError();
          }
          break;
      }
    }
  };

  private void onPrepareFailed() {

  }

  private void onStartOrStopFailed() {

  }

  private void onStreamingError() {

  }

  private void onOpenDeviceFailed() {

  }

}
