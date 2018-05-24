package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;

import cn.hachchina.nuaa.smartmedical.R;

/**
 * Created by Administrator on 2018/5/20.
 */

public class RingActivity extends Activity{
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ring_activity_layout);

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock w1 = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP
                | PowerManager.FULL_WAKE_LOCK, "AlertDialog");
        w1.acquire();

        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock keyguardLock = keyguardManager
                .newKeyguardLock("AlertDialog");
        keyguardLock.disableKeyguard();

//        Log.i("alarm:", "alarm....");


        mediaPlayer = mediaPlayer.create(this, R.raw.pig);
        mediaPlayer.start();
        new AlertDialog.Builder(RingActivity.this).setTitle("闹钟").setMessage("吃感冒灵")
                .setPositiveButton("关闭闹铃", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mediaPlayer.stop();
                        RingActivity.this.finish();
                    }
                }).show();
    }
}
