package com.strikeboy.wholewireless.ui;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.strikeboy.wholewireless.R;
import com.strikeboy.wholewireless.bluetooth.BluetoothWrapper;
import com.strikeboy.wholewireless.nfc.NfcWrapper;
import com.strikeboy.wholewireless.utils.LogWrapper;
import com.strikeboy.wholewireless.wifi.WifiWrapper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private WifiWrapper mWifiWrapper;
    private BluetoothWrapper mBluetoothWrapper;
    private NfcWrapper mNfcWrapper;
    private Button mRttButton;
    private Button mWifiSignalMonitorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWifiWrapper = new WifiWrapper(this);
        mBluetoothWrapper = new BluetoothWrapper(this);
        mNfcWrapper = new NfcWrapper(this);
        setContentView(R.layout.activity_main);
        mRttButton = (Button) findViewById(R.id.rtt);
        mRttButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RttActivity.class);
                startActivity(intent);
            }
        });
        mWifiSignalMonitorButton = (Button) findViewById(R.id.wifi_signal_monitor);
        mWifiSignalMonitorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WifiSignalMonitor.class);
                startActivity(intent);
            }
        });
        LogWrapper.d(TAG, "build version is:" + Build.VERSION.SDK_INT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mWifiWrapper.isAvailable()) {
            LogWrapper.d(TAG, "wifi is ready");
            mWifiSignalMonitorButton.setVisibility(View.VISIBLE);
            WifiInfo wifiInfo = mWifiWrapper.getConnectionInfo();
            if (wifiInfo != null) {
                LogWrapper.d(TAG, "\n" +
                        "connected wifi：" +
                         "\n    ssid:" + wifiInfo.getSSID() +
                         "\n    linkSpeed:" + wifiInfo.getLinkSpeed());
            } else {
                LogWrapper.d(TAG, "no connected wifi");
            }

            List<WifiConfiguration> wifiConfigurations = mWifiWrapper.getConfiguredNetworks();
            for (WifiConfiguration configuration : wifiConfigurations) {
                LogWrapper.d(TAG, "ssid:" + configuration.SSID + " presharedkey:" +
                        configuration.preSharedKey + " allowedPairwiseCiphers" +
                        configuration.allowedPairwiseCiphers);
            }
        }

        if (mWifiWrapper.isP2pSupported()) {
            LogWrapper.d(TAG, "P2p supported");
        }

        if (mWifiWrapper.is5GHzBandSupported()) {
            LogWrapper.d(TAG, "5GHz band supported");
        }

        if (mWifiWrapper.isDeviceToApRttSupported()) {
            LogWrapper.d(TAG,"Device to Ap Rtt supported");
            mRttButton.setVisibility(View.VISIBLE);
        }

        if (mNfcWrapper.isAvailable()) {
            LogWrapper.d(TAG, "NFC is ready");
        }

        if (mBluetoothWrapper.isAvailable()) {
            LogWrapper.d(TAG, "Bluetooth is ready");
        }

    }
}
