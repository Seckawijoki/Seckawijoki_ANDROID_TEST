@echo off

set mPathNdkBuildCmd=D:\android-ndk-r10d\ndk-build.cmd
set mPathNdkBuildCmd=D:\sdk-manager\sdk\ndk-bundle\ndk-build.cmd
set mNdkBuildAbi=armeabi,armeabi-v7a,arm64-v8a,x86,x86_64,mips,mips64
set mNdkBuildAbi=all
set mDrive=f:
set mPathProjectAndroid=F:\Android_Studio_projects\Seckawijoki_ANDROID_TEST
set mDirNdkLibsOut=jniLibs
set mPathBuildBatch=%~dp0

call %mPathBuildBatch%\ndk_build_seckawijoki_androidtest.bat
call %mPathBuildBatch%\ndk_build_seckawijoki_androidtest_copy_so_files.bat