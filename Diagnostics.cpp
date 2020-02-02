#include "jni.h"
#include "Profiler.h"
#ifdef _WIN64
#include <windows.h>
#include <psapi.h>
#endif


JNIEXPORT jlong JNICALL Java_Profiler_totalProcessVirtualMemory
(JNIEnv*, jobject) {
#ifdef _WIN64
    PROCESS_MEMORY_COUNTERS ppsmemCounters;
    BOOL result = GetProcessMemoryInfo(GetCurrentProcess(),
        &ppsmemCounters,
        sizeof(ppsmemCounters));
    return ppsmemCounters.PagefileUsage;
#endif
    // #ifdef for linux here
    return 0;
}