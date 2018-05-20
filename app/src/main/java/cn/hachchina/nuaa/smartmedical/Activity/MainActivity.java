package cn.hachchina.nuaa.smartmedical.Activity;


import android.app.AlertDialog;

import android.app.PendingIntent;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import java.util.Calendar;

import cn.hachchina.nuaa.smartmedical.Bean.UserBean;
import cn.hachchina.nuaa.smartmedical.Bean.ViewBean_MainActivity;
import cn.hachchina.nuaa.smartmedical.R;

import cn.hachchina.nuaa.smartmedical.Util.VerifyPermissionUtil;

import cn.hachchina.nuaa.smartmedical.Util.PhoneUtil;
import cn.hachchina.nuaa.smartmedical.msc.VoiceHelper;


public class MainActivity extends VoiceHelper  {

    private ViewBean_MainActivity views;

    public static UserBean userBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        if (Build.VERSION.SDK_INT >= 23) {
            VerifyPermissionUtil verifyPermissionUtil = new VerifyPermissionUtil(MainActivity.this);
            verifyPermissionUtil.RequestPermission();
        }

        init();


    }

    private void init() {
        TelephonyManager tm = (TelephonyManager) MainActivity.this.getSystemService(MainActivity.this.TELEPHONY_SERVICE);
        PhoneStateListener listener = new PhoneStateListener() {
            @java.lang.Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                switch (state) {
                    case TelephonyManager.CALL_STATE_RINGING:
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        //   Log.e("info","开始通话");
                       /* for (int i=0;i<10;i++){
                            Log.e("info","play");
                            //string2Voice(MainActivity.this,"紧急情况，紧急情况，我的主人在杭州电子科技大学科技馆遇到突发情况需要120救援");
                        }*/
//
//                        //  PhoneUtil.endCall(MainActivity.this);
//                        for (int i = 0; i < 3; i++) {
//                            string2Voice(MainActivity.this, "紧急情况，紧急情况，我的主人在杭州电子科技大学科技馆遇到突发情况需要妖二零救援");
//                        }

                        break;
                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                }
            }
        };
        tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);

        userBean = new UserBean();

        views = new ViewBean_MainActivity();
        views.IV_DiseaseDiagnosis = findViewById(R.id.disease_diagnosis);
        views.IV_DoctorAppointment = findViewById(R.id.doctor_appointment);
        views.IV_DrugInstructionManual = findViewById(R.id.drug_instruction_manual);
        views.IV_EmergencyCall = findViewById(R.id.emergency_call);
        views.IV_MedicationRemider = findViewById(R.id.medication_remider);
        views.IV_RemotDiagnosis = findViewById(R.id.remote_diagnosis);
        views.IV_VoiceAssistant = findViewById(R.id.voice_assistant);

        views.IV_UserSelf = findViewById(R.id.userer);


        views.IV_DoctorAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, GuaHaoActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        views.IV_DrugInstructionManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ShuomingshuActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });


        views.IV_MedicationRemider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AlarmActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        views.IV_RemotDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, XinLv.class);
                MainActivity.this.startActivity(intent);
            }
        });

        views.IV_VoiceAssistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voice2String(MainActivity.this);
            }
        });

        views.IV_DiseaseDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PlayRecordUtil playRecordUtil = new PlayRecordUtil();
//                playRecordUtil.startPlaying();

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, JBZZActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });


        views.IV_EmergencyCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PhoneUtil.callPhone(MainActivity.this, userBean.getDefault_EmergencyContact_Number());


            }
        });


        views.IV_UserSelf.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, GerenzhongxinActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });


    }

    @Override
    protected void voiceCallback() {
        // TODO : 获取语音识别的字符串，直接使用resultJson即可

       // Toast.makeText(MainActivity.this,"识别结果: "+resultJson,Toast.LENGTH_LONG).show();
        if (resultJson.contains("说明书")||resultJson.contains("白")){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, BaijiaheiShuomingshuActivity.class);
            MainActivity.this.startActivity(intent);
        }else if (resultJson.contains("体温")||resultJson.contains("度")){
            Intent intent = new Intent(MainActivity.this, MaiYao.class);
            startActivity(intent);
        }else if (resultJson.contains("心率")||resultJson.contains("检测")){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, XinLv.class);
            MainActivity.this.startActivity(intent);
        }

    }

    @Override
    protected void stringCallback() {

    }


}
