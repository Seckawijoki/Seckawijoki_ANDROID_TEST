//
// Created by Seckawijoki on 2018/6/2 at 11:37 under Windows10 Professional.
//

#include "InvokingJava.h"
#include <android/log.h>

extern JNIEnv *jniEnv;
jclass InvokedJava;
jobject mInvokedJava;
jmethodID javaMethod;
jmethodID javaStaticMethod;
const char* const TAG = "JNIMsg";
int GetInstance(jclass obj_class);
int InitInvokedJava(){
    __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 1");
    if (jniEnv == NULL){
        return 0;
    }
    if (InvokedJava == NULL){
        jclass tmp = (*jniEnv)->FindClass(jniEnv, "com/seckawijoki/androidtest/tool/InvokedJava");
        InvokedJava = (jclass)(*jniEnv)->NewGlobalRef(jniEnv, tmp);
        if (InvokedJava == NULL){
            return -1;
        }
        (*jniEnv)->DeleteLocalRef(jniEnv, tmp);
        __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 2 ok");
    }
    if (mInvokedJava == NULL){
        if (GetInstance(InvokedJava) != 1){
            (*jniEnv)->DeleteGlobalRef(jniEnv, InvokedJava);
            return -1;
        }
        __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 3 ok");
    }
    if (javaMethod == NULL){
        javaMethod = (*jniEnv)->GetMethodID(jniEnv, InvokedJava, "javaMethod", "()V");
        if (javaMethod == NULL){
            (*jniEnv)->DeleteGlobalRef(jniEnv, InvokedJava);
            (*jniEnv)->DeleteGlobalRef(jniEnv, mInvokedJava);
            return -2;
        }
        __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 4 ok");
    }
    if (javaStaticMethod == NULL){
        javaStaticMethod = (*jniEnv)->GetStaticMethodID(jniEnv, InvokedJava, "javaStaticMethod", "()V");
        if (javaStaticMethod == NULL){
            (*jniEnv)->DeleteGlobalRef(jniEnv, InvokedJava);
            (*jniEnv)->DeleteGlobalRef(jniEnv, mInvokedJava);
            (*jniEnv)->DeleteGlobalRef(jniEnv, javaMethod);
            return -3;
        }
        __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 5 ok");
    }
    __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 6 ok");
    return 1;
}
int GetInstance(jclass obj_class){
    if (obj_class == NULL){
        return 0;
    }
    jmethodID constructor_id = (*jniEnv)->GetMethodID(jniEnv, obj_class, "<init>", "()V");
    if (constructor_id == 0){
        return -1;
    }
    jobject object = (*jniEnv)->NewObject(jniEnv, obj_class, constructor_id);
    mInvokedJava = (*jniEnv)->NewGlobalRef(jniEnv, object);
    if (mInvokedJava == NULL){
        return -2;
    }
    (*jniEnv)->DeleteLocalRef(jniEnv, object);
    return 1;
}
void InvokeJavaStaticMethod(){
    if (InvokedJava == NULL || javaStaticMethod == NULL){
        int init_result = InitInvokedJava();
        if (init_result != 1){
            return;
        }
    }
    __android_log_print(ANDROID_LOG_INFO, TAG, "InvokeJavaStaticMethod() begin");
    (*jniEnv)->CallStaticVoidMethod(jniEnv, InvokedJava, javaStaticMethod);
    __android_log_print(ANDROID_LOG_INFO, TAG, "InvokeJavaStaticMethod() end");
}
void InvokeJavaMethod(){
    if (InvokedJava == NULL || mInvokedJava == NULL || javaMethod == NULL){
        int init_result = InitInvokedJava();
        if (init_result != 1){
            return;
        }
    }
    __android_log_print(ANDROID_LOG_INFO, TAG, "InvokeJavaMethod() begin");
    (*jniEnv)->CallVoidMethod(jniEnv, mInvokedJava, javaMethod);
    __android_log_print(ANDROID_LOG_INFO, TAG, "InvokeJavaMethod() end");
}
