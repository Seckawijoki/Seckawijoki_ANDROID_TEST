//
// Created by Seckawijoki on 2018/6/1 at 18:28 under Windows-10 Professional.
//
#include <jni.h>
#include "com_seckawijoki_androidtest_tool_ImplicitNativeHelper.h"
#include "ImplicitInvokingJava.h"
#include "AppPlayNetworkObserver.h"
JNIEnv *jniEnv;

JNIEXPORT jstring JNICALL
Java_com_seckawijoki_androidtest_tool_ImplicitNativeHelper_getAppKey(JNIEnv *env, jobject type) {
    // TODO
    //char* app_key  = "app_key153575478568";
    return (*env)->NewStringUTF(env, "app_key153575478568");
}

JNIEXPORT void JNICALL
Java_com_seckawijoki_androidtest_tool_ImplicitNativeHelper_invokeJavaFromC(JNIEnv *env, jobject type) {
    jniEnv = env;
    InvokeJavaMethod();
    InvokeJavaStaticMethod();
    GetGreeting();
    SayHelloToJava();
}
JNIEXPORT void JNICALL
Java_com_seckawijoki_androidtest_tool_ImplicitNativeHelper_zeroDivision(JNIEnv *env, jobject type) {
    float a = 1.0;
    a = a/0;
}
JNIEXPORT void JNICALL
Java_org_appplay_lib_AppPlayNatives_nativeOnNetwork(JNIEnv *env, jobject type, jint networkCallbackType) {
    jniEnv = env;
    
    OnNetworkCallback(networkCallbackType);
}