//
// Created by Seckawijoki on 2018/6/1.
//
#include <jni.h>
#include <android/log.h>
#include "com_seckawijoki_androidtest_tool_ImplicitNativeHelper.h"

/**
 * Class: com_seckawijoki_androidtest_tool_ImplicitNativeHelper
 * Method: callFromMainLib
 * Signature: ()Ljava/lang/String;
 */
extern "C"
JNIEXPORT jstring JNICALL
Java_com_seckawijoki_androidtest_tool_ImplicitNativeHelper_callFromMainLib
        (JNIEnv *env,  jobject type)
{
    return (*env).NewStringUTF("call from implicitnative-lib");
}