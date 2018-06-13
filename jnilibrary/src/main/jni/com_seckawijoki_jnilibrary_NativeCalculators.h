//
// Created by Seckawijoki on 2018/6/7 at 17:41 under Windows-10 Professional.
//

#ifndef SECKAWIJOKI_ANDROID_TEST_COM_SECKAWIJOKI_JNILIBRARY_NATIVECALCULATORS_H
#define SECKAWIJOKI_ANDROID_TEST_COM_SECKAWIJOKI_JNILIBRARY_NATIVECALCULATORS_H

#ifdef __cplusplus
extern "C"
{
#endif
/**
 * Package: com/seckawijoki/jnilibrary
 * Class: NativeCalculators
 * Signature: (I;I)I
 */
JNIEXPORT jint JNICALL
Java_com_seckawijoki_jnilibrary_NativeCalculators_add(JNIEnv *, jobject , jint , jint );


#ifdef  __cplusplus
}
#endif

#endif //SECKAWIJOKI_ANDROID_TEST_COM_SECKAWIJOKI_JNILIBRARY_NATIVECALCULATORS_H
