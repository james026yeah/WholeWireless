package com.strikeboy.wholewireless.ui;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.strikeboy.wholewireless.R;
import com.strikeboy.wholewireless.bluetooth.BluetoothWrapper;
import com.strikeboy.wholewireless.nfc.NfcWrapper;
import com.strikeboy.wholewireless.utils.LogWrapper;
import com.strikeboy.wholewireless.wifi.WifiWrapper;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private WifiWrapper mWifiWrapper;
    private BluetoothWrapper mBluetoothWrapper;
    private NfcWrapper mNfcWrapper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWifiWrapper = new WifiWrapper(this);
        mBluetoothWrapper = new BluetoothWrapper(this);
        mNfcWrapper = new NfcWrapper(this);
        setContentView(R.layout.activity_main);
        LogWrapper.d(TAG, "build version is:" + Build.VERSION.SDK_INT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mWifiWrapper.isAvailable()) {
            LogWrapper.d(TAG, "wifi is ready");
        }

        if (mWifiWrapper.isP2pSupported()) {
            LogWrapper.d(TAG, "P2p supported");
        }

        if (mWifiWrapper.is5GHzBandSupported()) {
            LogWrapper.d(TAG, "5GHz band supported");
        }

        if (mWifiWrapper.isDeviceToApRttSupported()) {
            LogWrapper.d(TAG,"Device to Ap Rtt supported");
        }

        if (mNfcWrapper.isAvailable()) {
            LogWrapper.d(TAG, "NFC is ready");
        }

        if (mBluetoothWrapper.isAvailable()) {
            LogWrapper.d(TAG, "Bluetooth is ready");
        }

    }
}
