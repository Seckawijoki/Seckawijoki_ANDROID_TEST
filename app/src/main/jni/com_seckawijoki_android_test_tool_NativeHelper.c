//
// Created by Seckawijoki on 2018/6/1 at 18:28 under Windows10 Professional.
//
#include <jni.h>
#include "com_seckawijoki_android_test_tool_NativeHelper.h"


JNIEXPORT jstring JNICALL
Java_com_seckawijoki_android_1test_tool_NativeHelper_getAppKey(JNIEnv *env, jclass type) {
    // TODO
    char* app_key  = "app_key153575478568";
    return (*env)->NewStringUTF(env, app_key);
}
