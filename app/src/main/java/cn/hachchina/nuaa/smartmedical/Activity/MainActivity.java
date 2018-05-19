package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import cn.hachchina.nuaa.smartmedical.Bean.UserBean;
import cn.hachchina.nuaa.smartmedical.Bean.ViewBean_MainActivity;
import cn.hachchina.nuaa.smartmedical.R;
import cn.hachchina.nuaa.smartmedical.Util.PlayRecordUtil;
import cn.hachchina.nuaa.smartmedical.Util.VerifyPermissionUtil;

import static cn.hachchina.nuaa.smartmedical.Util.CallPhoneUtil.call;

public class MainActivity extends Activity {

    private ViewBean_MainActivity views;
    private UserBean userBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        init();


    }

    private void init() {
        if (Build.VERSION.SDK_INT >= 23) {
            VerifyPermissionUtil verifyPermissionUtil = new VerifyPermissionUtil(MainActivity.this);
            verifyPermissionUtil.RequestPermission();
        }

        userBean = new UserBean();

        views = new ViewBean_MainActivity();

        views.IV_DiseaseDiagnosis = findViewById(R.id.disease_diagnosis);
        views.IV_DoctorAppointment = findViewById(R.id.doctor_appointment);
        views.IV_DrugInstructionManual = findViewById(R.id.drug_instruction_manual);
        views.IV_EmergencyCall = findViewById(R.id.emergency_call);
        views.IV_MedicationRemider = findViewById(R.id.medication_remider);
        views.IV_RemotDiagnosis = findViewById(R.id.remote_diagnosis);
        views.IV_VoiceAssistant = findViewById(R.id.voice_assistant);

        views.IV_DoctorAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

            }
        });

        views.IV_RemotDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        views.IV_VoiceAssistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                String s = userBean.getDefault_EmergencyContact_Number();
                call(s, MainActivity.this);
            }
        });


    }


}
