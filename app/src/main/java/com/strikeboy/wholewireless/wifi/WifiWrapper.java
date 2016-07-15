package com.strikeboy.wholewireless.wifi;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;

import java.util.List;

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

    public boolean isAvailable() {
        //wifi is always available
        return true;

    }

    public void startScan() {
        mWifiManager.startScan();
    }

    public WifiInfo getConnectionInfo() {
        return mWifiManager.getConnectionInfo();
    }

    public List<WifiConfiguration> getConfiguredNetworks() {
        return mWifiManager.getConfiguredNetworks();
    }

    public List<ScanResult> getScanResults() {
        return mWifiManager.getScanResults();
    }

    public boolean isP2pSupported() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            return mWifiManager.isP2pSupported();
        }
        return false;
    }

    public boolean is5GHzBandSupported() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            return mWifiManager.is5GHzBandSupported();
        }
        return false;
    }

    public boolean isDeviceToApRttSupported() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            return mWifiManager.isDeviceToApRttSupported();
        }
        return false;
    }


}
