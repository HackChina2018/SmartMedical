package cn.hachchina.nuaa.smartmedical.Util;

import android.media.MediaPlayer;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;


public class PlayRecordUtil {
    private static String mFileName = null;
    private String strOutFileName = "demo.mp3";
    private MediaPlayer mPlayer = null;

    public PlayRecordUtil() {
        File sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        mFileName = sdDir.toString() + "/smartmedical/" + strOutFileName;
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    public void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e("info", "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    private void PlayRecord() {
        boolean mStartPlaying = true;
        onPlay(mStartPlaying);

        mStartPlaying = !mStartPlaying;
    }


}
