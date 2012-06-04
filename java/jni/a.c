#include "stdio.h"
#include "HelloJNI.h"

JNIEXPORT void JNICALL Java_HelloJNI_hello
  (JNIEnv *a, jclass b){
  
  printf("hello,dare!\n");
  
  }

