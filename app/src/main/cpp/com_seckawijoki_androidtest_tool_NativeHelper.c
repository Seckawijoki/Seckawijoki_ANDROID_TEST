//
// Created by Seckawijoki on 2018/6/1 at 18:28 under Windows10 Professional.
//
#include <jni.h>
#include "com_seckawijoki_androidtest_tool_NativeHelper.h"

//extern "C"
JNIEXPORT jstring JNICALL
Java_com_seckawijoki_androidtest_tool_NativeHelper_getAppKey(JNIEnv *env, jobject type) {
    // TODO
    //char* app_key  = "app_key153575478568";
    return (*env)->NewStringUTF(env, "app_key153575478568");
}
