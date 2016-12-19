#include <jni.h>
#include <string.h>

JNIEXPORT jstring JNICALL
Java_com_ken_hellojni_EncodeAESUtil_getCodeFromJni(JNIEnv *env, jobject instance) {

   return (*env)->NewStringUTF(env, "Hello from JNI");
}