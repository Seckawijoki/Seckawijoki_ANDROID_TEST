//
// Created by Seckawijoki on 2018/6/2 at 11:37 under Windows10 Professional.
//
#ifndef IMPLICIT_INVOKING_JAVA_H
#define IMPLICIT_INVOKING_JAVA_H
#include <string.h>
#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif


void InvokeJavaMethod();
void InvokeJavaStaticMethod();
void GetGreeting();
void SayHelloToJava();

#ifdef __cplusplus
}
#endif

#endif //IMPLICIT_INVOKING_JAVA_H
