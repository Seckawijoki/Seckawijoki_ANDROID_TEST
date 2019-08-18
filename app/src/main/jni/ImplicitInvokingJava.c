//
// Created by Seckawijoki on 2018/6/2 at 11:37 under Windows10 Professional.
//

#include "ImplicitInvokingJava.h"
#include <android/log.h>

extern JNIEnv *jniEnv;
jclass InvokedJava;
jobject mInvokedJava;
jmethodID javaMethod;
jmethodID javaStaticMethod;
jmethodID getGreeting;
jmethodID sayHelloToJava;
const int SUCCESSFUL = 1;
const char* const TAG = "ImplicitInvokingJava.c";
void DeleteStaticMethods(){
    (*jniEnv)->DeleteGlobalRef(jniEnv, javaStaticMethod);
    (*jniEnv)->DeleteGlobalRef(jniEnv, getGreeting);
}
void DeleteMethods(){
    (*jniEnv)->DeleteGlobalRef(jniEnv, javaMethod);
    (*jniEnv)->DeleteGlobalRef(jniEnv, sayHelloToJava);
}

void DeleteClass(){
    (*jniEnv)->DeleteGlobalRef(jniEnv, InvokedJava);
}
void DeleteObjects() {
    (*jniEnv)->DeleteGlobalRef(jniEnv, mInvokedJava);
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
    return SUCCESSFUL;
}
int InitInvokedJava(){
    __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 1");
    if (jniEnv == NULL){
        return 0;
    }
    if (InvokedJava == NULL){
        jclass tmp = (*jniEnv)->FindClass(jniEnv, "com/seckawijoki/androidtest/tool/ImplicitInvokedJava");
        InvokedJava = (jclass)(*jniEnv)->NewGlobalRef(jniEnv, tmp);
        if (InvokedJava == NULL){
            return -1;
        }
        (*jniEnv)->DeleteLocalRef(jniEnv, tmp);
        __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 2 ok");
    }
    if (mInvokedJava == NULL){
        if (GetInstance(InvokedJava) != 1){
            DeleteClass();
            return -1;
        }
        __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 3 ok");
    }
    if (javaMethod == NULL){
        javaMethod = (*jniEnv)->GetMethodID(jniEnv, InvokedJava, "javaMethod", "()V");
        if (javaMethod == NULL){
            DeleteClass();
            DeleteObjects();
            return -2;
        }
        __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 4 ok");
    }
    if (javaStaticMethod == NULL){
        javaStaticMethod = (*jniEnv)->GetStaticMethodID(jniEnv, InvokedJava, "javaStaticMethod", "()V");
        if (javaStaticMethod == NULL){
//            (*jniEnv)->DeleteGlobalRef(jniEnv, InvokedJava);
//            (*jniEnv)->DeleteGlobalRef(jniEnv, mInvokedJava);
//            (*jniEnv)->DeleteGlobalRef(jniEnv, javaMethod);
            DeleteClass();
            DeleteObjects();
            DeleteMethods();
            return -3;
        }
        __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 5 ok");
    }
    __android_log_print(ANDROID_LOG_INFO, TAG, "InitInvokedJava() begin 6 ok");
    return SUCCESSFUL;
}
void InvokeJavaStaticMethod(){
    if (InvokedJava == NULL || javaStaticMethod == NULL){
        int init_result = InitInvokedJava();
        if (init_result != SUCCESSFUL){
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
        if (init_result != SUCCESSFUL){
            return;
        }
    }
    __android_log_print(ANDROID_LOG_INFO, TAG, "InvokeJavaMethod() begin");
    (*jniEnv)->CallVoidMethod(jniEnv, mInvokedJava, javaMethod);
    __android_log_print(ANDROID_LOG_INFO, TAG, "InvokeJavaMethod() end");
}
void GetGreeting(){
    if (InvokedJava == NULL){
        int init_result = InitInvokedJava();
        if (init_result != SUCCESSFUL){
            return;
        }
    }
    if (getGreeting == NULL){
        getGreeting = (*jniEnv)->GetStaticMethodID(jniEnv, InvokedJava, "getGreeting", "()Ljava/lang/String;");
        if (getGreeting == NULL){
            DeleteClass();
            DeleteObjects();
            DeleteMethods();
            return;
        }
    }
    jstring value = NULL;
    const char *cstr = NULL;
    __android_log_print(ANDROID_LOG_INFO, TAG, "GetGreeting() begin");
    value = (*jniEnv)->CallStaticObjectMethod(jniEnv, InvokedJava, getGreeting);
    cstr = (*jniEnv)->GetStringUTFChars(jniEnv, value, 0);
    __android_log_print(ANDROID_LOG_DEBUG, TAG, "GetGreeting(): getGreeting() = %s", cstr);
    __android_log_print(ANDROID_LOG_INFO, TAG, "GetGreeting() end");
    (*jniEnv)->ReleaseStringUTFChars(jniEnv, value, cstr);
    (*jniEnv)->DeleteLocalRef(jniEnv, value);
}
void SayHelloToJava(){
    if (mInvokedJava == NULL || InvokedJava == NULL){
        int init_result = InitInvokedJava();
        if (init_result != SUCCESSFUL){
            return;
        }
    }
    if (sayHelloToJava == NULL){
        sayHelloToJava = (*jniEnv)->GetMethodID(jniEnv, InvokedJava, "sayHelloToJava", "(Ljava/lang/String;)V");
        if (sayHelloToJava == NULL){
            DeleteClass();
            DeleteObjects();
            return;
        }
    }
//    char *cstr = "Hi, I'm from C.";
//    jstring param = (*jniEnv)->NewStringUTF(jniEnv, cstr);
    jstring param = (*jniEnv)->NewStringUTF(jniEnv, "Hi, I'm from C!");
    __android_log_print(ANDROID_LOG_INFO, TAG, "sayHelloToJava() begin");
    (*jniEnv)->CallVoidMethod(jniEnv, mInvokedJava, sayHelloToJava, param);
    __android_log_print(ANDROID_LOG_INFO, TAG, "sayHelloToJava() end");
//    (*jniEnv)->ReleaseStringUTFChars(jniEnv, param, cstr);
//    if (cstr != NULL)    (*jniEnv)->DeleteLocalRef(jniEnv, cstr);
    if (param != NULL)(*jniEnv)->DeleteLocalRef(jniEnv, param);
}
