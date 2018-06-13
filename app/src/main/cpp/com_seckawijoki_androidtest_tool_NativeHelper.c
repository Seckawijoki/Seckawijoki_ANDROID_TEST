//
// Created by Seckawijoki on 2018/6/1 at 18:28 under Windows10 Professional.
//
#include <jni.h>
#include "com_seckawijoki_androidtest_tool_NativeHelper.h"
#include "InvokingJava.h"
JNIEnv *jniEnv;

JNIEXPORT jstring JNICALL
Java_com_seckawijoki_androidtest_tool_NativeHelper_getAppKey(JNIEnv *env, jobject type) {
    // TODO
    //char* app_key  = "app_key153575478568";
    return (*env)->NewStringUTF(env, "f2a40e80-d97f-4d16-bb1c-cfe7ce6edf2c");
}

JNIEXPORT void JNICALL
Java_com_seckawijoki_androidtest_tool_NativeHelper_invokeJavaFromC(JNIEnv *env, jobject type) {
    if (jniEnv == NULL){
        jniEnv = env;
    }
    InvokeJavaMethod();
    InvokeJavaStaticMethod();
    GetGreeting();
    SayHelloToJava();
}
JNIEXPORT void JNICALL
Java_com_seckawijoki_androidtest_tool_NativeHelper_zeroDivision(JNIEnv *env, jobject type) {
    float a = 1.0;
    a = a/0;
}