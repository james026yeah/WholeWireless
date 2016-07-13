package com.strikeboy.wholewireless.utils;

import android.util.Log;

/**
 * Created by ruby on 7/13/16.
 */
public class LogWrapper {
    public static String TAG = "WholeTools";

    public static void d(String tag, String msg) {
        Log.d(TAG, tag + "--->" + msg);
    }

    public static void e(String tag, String msg) {
        Log.e(TAG, tag + "--->" + msg);
    }
}
