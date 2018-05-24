package cn.hachchina.nuaa.smartmedical.Util;

import android.telephony.PhoneStateListener;

public class MyPhoneStateListener extends PhoneStateListener {
    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);

    }
}
