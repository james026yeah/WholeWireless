package com.strikeboy.wholewireless.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;

/**
 * Created by ruby on 7/13/16.
 */
public class BluetoothWrapper {

    private Context mContext;
    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;

    public BluetoothWrapper(Context context) {
        mContext = context;
        mBluetoothManager = (BluetoothManager)mContext.getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = mBluetoothManager.getAdapter();
    }

    public boolean isReady() {
        if (mBluetoothAdapter != null) {
            return true;
        } else {
            return false;
        }
    }
}
