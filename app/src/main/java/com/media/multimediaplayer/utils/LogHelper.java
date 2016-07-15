package com.media.multimediaplayer.utils;

import android.util.Log;

/**
 * Created by zhangjiqing on 16/7/15.
 */
public class LogHelper {

    // The max length of tag is 23. So the max index is 22;
    private final static int MAX_TAG_END_INDEX = 22;

    private final static String LOG_PREFIX = "PLAYER_";

    private static boolean enableVerbose = true;
    private static boolean enableDebug = true;
    private static boolean enableWarn = true;
    private static boolean enableError = true;

    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }

    public static String makeLogTag(String str) {
        String result = LOG_PREFIX + str;
        return result.substring(0, MAX_TAG_END_INDEX);
    }

    public static void v(String tag, Object... messages) {
        if (enableVerbose) {
            log(tag, Log.VERBOSE, null, messages);
        }
    }

    public static void d(String tag, Object... messages) {
        if (enableDebug) {
            log(tag, Log.DEBUG, null, messages);
        }
    }

    public static void w(String tag, Object... messages) {
        if (enableWarn) {
            log(tag, Log.WARN, null, messages);
        }
    }

    public static void w(String tag, Throwable throwable, Object... messages) {
        if (enableWarn) {
            log(tag, Log.WARN, throwable, messages);
        }
    }

    public static void e(String tag, Object... messages) {
        if (enableError) {
            log(tag, Log.ERROR, null, messages);
        }
    }

    public static void e(String tag, Throwable throwable, Object... messages) {
        if (enableError) {
            log(tag, Log.ERROR, throwable, messages);
        }
    }

    private static void log(String tag, int level, Throwable throwable, Object... msgs) {
        if (null != tag) {
            tag = tag.substring(0, MAX_TAG_END_INDEX);
        }

        if (Log.isLoggable(tag, level)) {
            StringBuilder strBuilder = new StringBuilder();

            if (null != msgs) {
                for (Object obj : msgs) {
                    strBuilder.append(obj);
                }
            }

            if (null != throwable) {
                strBuilder.append("\n").append(Log.getStackTraceString(throwable));
            }

            Log.println(level, tag, strBuilder.toString());
        }
    }
}
