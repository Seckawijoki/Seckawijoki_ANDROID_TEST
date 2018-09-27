LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
# LOCAL_LDLIBS    := -lm -llog
LOCAL_LDLIBS := -L$(SYSROOT)/usr/lib -llog
LOCAL_MODULE    := ImplicitNativeHelper
# FILE_LIST := com_seckawijoki_androidtest_tool_ImplicitNativeHelper.c
# FILE_LIST += ImplicitInvokingJava.c
LOCAL_SRC_FILES := com_seckawijoki_androidtest_tool_ImplicitNativeHelper.c
LOCAL_SRC_FILES+=ImplicitInvokingJava.c
LOCAL_SRC_FILES+=AppPlayNetworkObserver.c
# LOCAL_C_INCLUDES := $(LOCAL_PATH)/app/src/main/
include $(BUILD_SHARED_LIBRARY)