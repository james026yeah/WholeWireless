package com.strikeboy.wholewireless.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.strikeboy.wholewireless.R;
import com.strikeboy.wholewireless.utils.LogWrapper;
import com.strikeboy.wholewireless.wifi.WifiWrapper;

import java.util.List;

public class WifiSignalMonitor extends AppCompatActivity {
    private String TAG = "WifiSignalMonitor";
    private WifiWrapper mWifiWrapper;
    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogWrapper.d(TAG, "WifiSignalMonitor");
        setContentView(R.layout.activity_wifi_signal_monitor);
        mWifiWrapper = new WifiWrapper(this);

        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {


                } else if (intent.getAction().equals(
                        WifiManager.NETWORK_STATE_CHANGED_ACTION)) {

                } else if (intent.getAction().equals(
                        WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
                    LogWrapper.d(TAG, "SCAN_RESULTS_AVAILABLE_ACTION");
                    handleScanResultsAvailableEvent();
                    mWifiWrapper.startScan();
                } else if (intent.getAction().equals(
                        WifiManager.RSSI_CHANGED_ACTION)) {
                    LogWrapper.d(TAG, "RSSI_CHANGED_ACTION");
                }
            }
        };
    }

    private void handleScanResultsAvailableEvent() {
        List<ScanResult> scanResults = mWifiWrapper.getScanResults();
        for (ScanResult result: scanResults) {
            LogWrapper.d(TAG, "\n" + result.SSID + "->info:\n"
                    + "    BSSID:" + result.BSSID
                    +"\n    capabilities:" + result.capabilities
                    +"\n    frequency:" + result.frequency
                    +"\n    channelwidth:" + result.channelWidth
                    +"\n    level:" + result.level
                    +"\n    centerFreq0:" + result.centerFreq0
                    +"\n    centerFreq1:" + result.centerFreq1);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(mReceiver, filter);
        mWifiWrapper.startScan();


    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }
}
