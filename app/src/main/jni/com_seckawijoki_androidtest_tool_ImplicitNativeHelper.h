//
// Created by Seckawijoki on 2018/6/1 at 18:28 under Windows10 Professional.
//

#ifndef SECKAWIJOKI_ANDROID_TEST_COM_SECKAWIJOKI_ANDROIDTEST_TOOL_IMPLICITNATIVEHELPER_H
#define SECKAWIJOKI_ANDROID_TEST_COM_SECKAWIJOKI_ANDROIDTEST_TOOL_IMPLICITNATIVEHELPER_H

#include <jni.h>

#ifdef __cplusplus
extern "C"{
#endif
/**
 * Class: com_seckawijoki_androidtest_tool_ImplicitNativeHelper
 * Method: getAppKey
 * Signature: ()Ljava/lang/String
 */
JNIEXPORT jstring JNICALL
Java_com_seckawijoki_androidtest_tool_ImplicitNativeHelper_getAppKey(JNIEnv *, jobject);
/**
 * Class: com_seckawijoki_androidtest_tool_ImplicitNativeHelper
 * Method: getAppKey
 * Signature: ()V
 */
JNIEXPORT void JNICALL
Java_com_seckawijoki_androidtest_tool_ImplicitNativeHelper_invokeJavaFromC(JNIEnv *, jobject);
/**
 * Class: com_seckawijoki_androidtest_tool_ImplicitNativeHelper
 * Method: zeroDivision
 * Signature: ()V
 */
JNIEXPORT void JNICALL
Java_com_seckawijoki_androidtest_tool_ImplicitNativeHelper_zeroDivision(JNIEnv *, jobject);
/**
 * Class: org_appplay_lib_AppPlayNatives
 * Method: nativeOnNetworkDisabled
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
Java_org_appplay_lib_AppPlayNatives_nativeOnNetwork(JNIEnv *, jobject, jint);


#ifdef __cplusplus
}
#endif

#endif //SECKAWIJOKI_ANDROID_TEST_COM_SECKAWIJOKI_ANDROIDTEST_TOOL_IMPLICITNATIVEHELPER_H
