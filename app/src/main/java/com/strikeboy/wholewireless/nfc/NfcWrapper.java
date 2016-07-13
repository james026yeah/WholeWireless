package com.strikeboy.wholewireless.nfc;

import android.content.Context;
import android.nfc.NfcManager;

/**
 * Created by ruby on 7/13/16.
 */
public class NfcWrapper {
    private Context mContext;
    private NfcManager mNfcManager;

    public NfcWrapper(Context context) {
        mContext = context;
        mNfcManager = (NfcManager)mContext.getSystemService(Context.NFC_SERVICE);
    }

    public boolean isReady() {
        if (mNfcManager.getDefaultAdapter() != null) {
            return true;
        } else {
            return false;
        }
    }
}
