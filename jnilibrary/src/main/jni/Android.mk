LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := nativecalculators-lib
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := com_seckawijoki_jnilibrary_NativeCalculators.cpp
include $(BUILD_SHARED_LIBRARY)