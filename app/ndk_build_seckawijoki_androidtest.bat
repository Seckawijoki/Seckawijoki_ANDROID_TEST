@echo off
%mDrive%
cd %mPathProjectAndroid%\app

del /q /s src\main\%mDirNdkLibsOut%\*

%mPathNdkBuildCmd% NDK_PROJECT_PATH=build/intermediates/ndk NDK_LIBS_OUT=src/main/%mDirNdkLibsOut% APP_BUILD_SCRIPT=src/main/jni/Android.mk NDK_APPLICATION_MK=src/main/jni/Application.mk ENGINE_ROOT_LOCAL=. NDK_MODULE_PATH=. APP_ABI:=%mNdkBuildAbi% APP_SHORT_COMMANDS:=false

pause