//
// Created by Seckawijoki on 2018/6/1 at 18:28 under Windows10 Professional.
//

#ifndef SECKAWIJOKI_ANDROID_TEST_COM_SECKAWIJOKI_ANDROIDTEST_TOOL_NATIVEHELPER_H
#define SECKAWIJOKI_ANDROID_TEST_COM_SECKAWIJOKI_ANDROIDTEST_TOOL_NATIVEHELPER_H

#include <jni.h>

#ifdef __cplusplus
extern "C"{
#endif
/**
 * Class: com_seckawijoki_androidtest_tool_NativeHelper
 * Method: getAppKey
 * Signature: ()Ljava/lang/String
 */
JNIEXPORT jstring JNICALL
Java_com_seckawijoki_androidtest_tool_NativeHelper_getAppKey(JNIEnv *, jobject);

JNIEXPORT void JNICALL
Java_com_seckawijoki_androidtest_tool_NativeHelper_invokeJavaFromC(JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif

#endif //SECKAWIJOKI_ANDROID_TEST_COM_SECKAWIJOKI_ANDROIDTEST_TOOL_NATIVEHELPER_H
