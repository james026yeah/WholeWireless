package com.strikeboy.wholewireless.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.strikeboy.wholewireless.R;
import com.strikeboy.wholewireless.wifi.WifiWrapper;

public class RttActivity extends AppCompatActivity {

    private WifiWrapper mWifiWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtt);
        mWifiWrapper = new WifiWrapper(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
