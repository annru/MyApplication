//
// Created by 00224524 on 2018/3/26.
//

#include <com_example_myapplication_JniUtils.h>

JNIEXPORT jstring JNICALL Java_com_example_myapplication_JniUtils_getStrFromC
        (JNIEnv * env, jclass clazz) {
    return env->NewStringUTF("hello, I am from C++");
}

