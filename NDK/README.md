
### Tải về/Cài đặt NDK cho Android Studio
 - Android Studio > Preferences > Appearance & Behavior > System Settings > Android SDK > SDK Tools
 - Cài đặt ```NDK, CMake, LLDB```
 
###### Đường dẫn tới NDK 
 - Open Module Settings > SDK Location Android NDK location, ex ```/Users/HN/Library/Android/sdk/ndk-bundle```
 - Trong local.properties sẽ là: ```ndk.dir=/Users/HN/Library/Android/sdk/ndk-bundle```


## Tạo thư viện:

#### 1. Tạo folder ```jni``` trong ```app/src/main/```
#### 2. Tạo file ```Android.mk``` như sau:
```java
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := jni-lib-name
LOCAL_SRC_FILES := native_code.c

include $(BUILD_SHARED_LIBRARY)
```

```jni-lib-name```: tên của thư viện : project nào sử dụng thì sẽ load thư viện này.

```native_code.c```: file code native : cung cấp các phương thức cho code Java gọi tới.


#### 3. Viết code thư native

```java 
#include <jni.h>
#include <string.h>

JNIEXPORT jstring JNICALL
Java_com_ken_hellojni_EncodeAESUtil_getCodeFromJni(JNIEnv *env, jobject instance) {
   // do something...
   return (*env)->NewStringUTF(env, "Hello from JNI");
}
```
>Cấu trúc tên hàm:
 - com_ken_hellojni: package sẽ gọi tới function này là : com.ken.hellojni
 - EncodeAESUtil: tên class sẽ gọi tới function này
 - getCodeFromJni: tên của funtion sẽ được sử dụng.

#### 4. Build thư viện để mang sang project khác sử dụng,

 *) Chuyển tới thư mục ```ndk-bundle```
 >$ cd /Users/HN/Library/Android/sdk/ndk-bundle/
 
 *) Chạy command với cấu trúc 
 >$ ndk-build NDK_APPLICATION_MK=/path/to/Android.mk NDK_PROJECT_PATH=/path/to/project/app/src/main/
   - Ví dụ: ```./ndk-build NDK_APPLICATION_MK=/Users/HN/Desktop/Android-Self-Study/NDK/FirstProjectBuildLib/app/src/main/jni/Android.mk NDK_PROJECT_PATH=/Users/HN/Desktop/Android-Self-Study/NDK/FirstProjectBuildLib/app/src/main/```
   


*** Nó sẽ gen ra 1 folder libs, xong phần build lib ***




## Sử dụng thư viện
Trong project ```SecondProjectUseLib```

#### 1. Tạo folder ```jniLibs``` trong ```app/src/main/```

#### 2. Copy toàn bộ nội dung trong folder ```libs``` của project ```FirstProjectBuildLib``` vừa gen được vào ```jniLibs```

#### 3. Sử dụng hàm vừa được viết ở trên 

 - Tạo package khớp với thư viện cung cấp, ```com.ken.hellojni```
 - Tạo tên class khớp với thư viện cung cấp, ```EncodeAESUtil```
 - Sử dụng function của thư viện trong class như sau: 
 
  *) Load thư viện:
  
  ```java
      static {
        System.loadLibrary("jni-lib-name");
      }
  ```
  *) Khai báo phương thức của thư viện:
  
  ```java
      public native String getCodeFromJni ();
  ```
  *) Giờ thì sử dụng function ```getCodeFromJni``` như các function java bình thường thôi.
 

 
 
 
 
 
 