package com.strikeboy.wholewireless.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * Created by ruby on 7/13/16.
 */
public class WifiWrapper {
    private Context mContext;
    private WifiManager mWifiManager;
    public WifiWrapper(Context context) {
        mContext = context;
        mWifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
    }

    public boolean isReady() {
        if (mWifiManager.isWifiEnabled()) {
            return true;
        } else {
            return false;
        }
    }
}
