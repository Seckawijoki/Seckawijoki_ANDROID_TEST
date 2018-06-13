//
// Created by Seckawijoki on 2018/6/7 at 17:41 under Windows-10 Professional.
//

#include <jni.h>
#include "com_seckawijoki_jnilibrary_NativeCalculators.h"


JNIEXPORT jint JNICALL
Java_com_seckawijoki_jnilibrary_NativeCalculators_add(JNIEnv *env, jobject type, jint a, jint b)
{
   return a+b;
}
