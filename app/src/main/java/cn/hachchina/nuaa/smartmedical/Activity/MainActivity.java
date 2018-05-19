package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;


import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
<<<<<<< HEAD
import android.widget.Toast;
=======
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
>>>>>>> upstream/master

import cn.hachchina.nuaa.smartmedical.Bean.UserBean;
import cn.hachchina.nuaa.smartmedical.Bean.ViewBean_MainActivity;
import cn.hachchina.nuaa.smartmedical.R;
import cn.hachchina.nuaa.smartmedical.Util.VerifyPermissionUtil;
import cn.hachchina.nuaa.smartmedical.msc.VoiceHelper;

import static cn.hachchina.nuaa.smartmedical.Util.CallPhoneUtil.call;

public class MainActivity extends VoiceHelper {

    private ViewBean_MainActivity views;
    Calendar c = Calendar.getInstance();
    private PendingIntent pi;

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
        views.IV_SetAlarm = findViewById(R.id.set_alarm);

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
                voice2String(MainActivity.this);
            }
        });

        views.IV_DiseaseDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PlayRecordUtil playRecordUtil = new PlayRecordUtil();
//                playRecordUtil.startPlaying();
                Toast.makeText(MainActivity.this,"info",Toast.LENGTH_SHORT).show();
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

        views.IV_SetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarmDate();

            }
        });


    }

    private void setAlarmDate() {

        final Calendar currentDate = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {

                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, monthOfYear);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                setAlarmTime(year,monthOfYear,dayOfMonth);
            }
        }, currentDate.get(Calendar.YEAR),
                currentDate.get(Calendar.MONTH),
                currentDate.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void setAlarmTime(final int year,
                              final int monthOfYear, final int dayOfMonth) {
        Calendar currentTime = Calendar.getInstance();
        // 创建一个TimePickerDialog实例，并把它显示出来。
        new TimePickerDialog(MainActivity.this, 0, // 绑定监听器
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker tp, int hourOfDay,
                                          int minute) {
//                        // 指定启动AlarmActivity组件
//                        Intent intent = new Intent();
//                        intent.setAction("android.intent.action.MAIN");// Activity
                        // 创建PendingIntent对象
//                        PendingIntent pi = PendingIntent.getActivity(
//                                MainActivity.this, 0, intent, 0);

                        Intent tempIntent = new Intent(MainActivity.this, AlarmActivity.class);
                        pi = PendingIntent.getActivity(MainActivity.this, 0, tempIntent, 0);


                        //设置当前时间
                        Calendar c = Calendar.getInstance();
                        c.setTimeInMillis(System.currentTimeMillis());
                        Log.i("TimeInMillis", "TimeInMillis_1"+c.getTimeInMillis()+"");
                        // 根据用户选择时间来设置Calendar对象
                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        c.set(Calendar.MINUTE, minute);

                        String longTime=year+"-"+(monthOfYear+1)+"-"+dayOfMonth+" "+hourOfDay
                                + ":" + minute;
                        //2016-10-25 10:44:53
//                        tv.setText(longTime);
//                        System.out.print("keke:" + longTime);
                        Log.i("keke:", longTime);

                        // 设置AlarmManager将在Calendar对应的时间启动指定组件
                        // 设置闹钟，当前时间就唤醒
                        AlarmManager alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
                        alarmManager.set(AlarmManager.RTC_WAKEUP,
                                c.getTimeInMillis(), pi);


                        Log.i("TimeInMillis", c.getTimeInMillis()+"");
                        // 显示闹铃设置成功的提示信息
                        Toast.makeText(MainActivity.this, "闹铃设置成功啦",
                                Toast.LENGTH_SHORT).show();
                    }
                }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
                .get(Calendar.MINUTE), true).show();

//        Intent tempIntent = new Intent();
//        tempIntent.setClass(MainActivity.this, AlarmActivity.class);
//        MainActivity.this.startActivity(tempIntent);
    }


    @Override
    protected void voiceCallback() {
        // TODO : 获取语音识别的字符串，直接使用resultJson即可
        Toast.makeText(MainActivity.this,"识别结果: "+resultJson,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void stringCallback() {

    }
}
