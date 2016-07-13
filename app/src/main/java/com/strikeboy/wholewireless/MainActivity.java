package com.strikeboy.wholewireless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mWifiWrapper.isReady()) {
            LogWrapper.d(TAG, "wifi is ready");
        }

        if (mNfcWrapper.isReady()) {
            LogWrapper.d(TAG, "NFC is ready");
        }

        if (mBluetoothWrapper.isReady()) {
            LogWrapper.d(TAG, "Bluetooth is ready");
        }

    }
}
