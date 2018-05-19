package cn.hachchina.nuaa.smartmedical.msc;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import java.io.IOException;

import cn.hachchina.nuaa.smartmedical.Util.MSCUtils.JsonParser;
import cn.hachchina.nuaa.smartmedical.Util.MSCUtils.StringUtil;

/**
 * Created by VULCAN on 2018/5/19.
 */

public abstract class VoiceHelper extends Activity{
    private String TAG = "VOICE HELPER";
    protected String resultJson = "";
    protected String savePath = "";

    protected void voice2String(Context context){
        resultJson = "";
        SpeechUtility.createUtility(context, SpeechConstant.APPID +"=5afcddee");
        RecognizerDialog iatDialog;
        iatDialog = new RecognizerDialog(context, mInitListener);
        //③设置监听，实现听写结果的回调
        iatDialog.setListener(new RecognizerDialogListener() {
            @Override
            public void onResult(RecognizerResult recognizerResult, boolean isLast) {
                String text = JsonParser.parseIatResult(recognizerResult.getResultString());
                System.out.println("-----------------   onResult   -----------------");
                if (!isLast) {
                    resultJson += text;
                } else {
                    Log.d(TAG, "recog result = " + resultJson);
                    voiceCallback();
                }
            }

            @Override
            public void onError(SpeechError speechError) {
                //自动生成的方法存根
                speechError.getPlainDescription(true);
            }
        });
        iatDialog.show();
    }

    protected void string2Voice(Context context, String text){
        savePath = "";
        SpeechUtility.createUtility(context, SpeechConstant.APPID +"=5afcddee");
        //1.创建SpeechSynthesizer对象, 第二个参数：本地合成时传InitListener
        SpeechSynthesizer mTts = SpeechSynthesizer.createSynthesizer(context, null);

        /**
         2.合成参数设置，详见《科大讯飞MSC API手册(Android)》SpeechSynthesizer 类
         *
         */

        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD); //设置云端
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");//设置发音人
        mTts.setParameter(SpeechConstant.SPEED, "50");//设置语速
        //设置合成音调
        mTts.setParameter(SpeechConstant.PITCH, "50");
        mTts.setParameter(SpeechConstant.VOLUME, "100");//设置音量，范围0~100
        mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");
        // 设置播放合成音频打断音乐播放，默认为true
        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        String outpath = Environment.getExternalStorageDirectory() + "/msc/"+ StringUtil.getRandomNameString();
        boolean isSuccess = mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, outpath);
//        Toast.makeText(context, "语音合成 保存音频到本地：\n" + isSuccess, Toast.LENGTH_LONG).show();
        //3.开始合成
        int code = mTts.startSpeaking(text, mSynListener);
        if (code == ErrorCode.SUCCESS){
            savePath = outpath;

                broadcastMedia(savePath);


            stringCallback();
        } else {
            if (code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED) {
                //上面的语音配置对象为初始化时：
                Toast.makeText(context, "语音组件未安装", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "语音合成失败,错误码: " + code, Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * 初始化监听器。
     */
    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            Log.d(TAG, "SpeechRecognizer init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                System.out.println("初始化失败,错误码："+code);
            }
        }
    };

    private SynthesizerListener mSynListener = new SynthesizerListener() {
        //会话结束回调接口，没有错误时，error为null
        public void onCompleted(SpeechError error) {
        }

        //缓冲进度回调
        //percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
        public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
        }

        //开始播放
        public void onSpeakBegin() {
        }

        //暂停播放
        public void onSpeakPaused() {
        }

        //播放进度回调
        //percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
        }

        //恢复播放回调接口
        public void onSpeakResumed() {
        }

        //会话事件回调接口
        public void onEvent(int arg0, int arg1, int arg2, Bundle arg3) {
        }
    };

    /**
     * 语言识别回调，需在应用处实现
     */
    abstract protected void voiceCallback();

    /**
     * 语言合成回调
     */
    abstract protected void stringCallback();

    public static void broadcastMedia(String path){
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getResultJson(){
        return resultJson;
    }

    public String getSavePath(){
        return savePath;
    }
}
