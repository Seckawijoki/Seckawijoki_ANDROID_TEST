//
// Created by Seckawijoki on 2018/7/21 at 16:30 under Windows-10 Professional.
//

#include "AppPlayNetworkObserver.h"
#include <android/log.h>

extern JNIEnv *jniEnv;

jclass g_jcAppPlayNetwork;

int GetJavaClass()
{
  if (g_jcAppPlayNetwork != NULL)
    return 1;
  jclass temp = (*jniEnv)->FindClass(jniEnv, "org/appplay/lib/AppPlayNetworkObserver");
  g_jcAppPlayNetwork = (jclass) (*jniEnv)->NewGlobalRef(jniEnv, temp);
  return 1;
}

void OnNetworkCallback(jint networkCallbackType)
{
  if (GetJavaClass() != 1){
    return;
  }
  jmethodID javaMethod = (*jniEnv)->GetStaticMethodID(jniEnv, g_jcAppPlayNetwork, "onNetworkCallback", "(I)V");
  if (javaMethod == NULL)
    return;
  __android_log_print(ANDROID_LOG_DEBUG, "AppPlayNetwork.c", "networkCallbackType = %d", networkCallbackType);
  (*jniEnv)->CallStaticVoidMethod(jniEnv, g_jcAppPlayNetwork, javaMethod, networkCallbackType);
}
