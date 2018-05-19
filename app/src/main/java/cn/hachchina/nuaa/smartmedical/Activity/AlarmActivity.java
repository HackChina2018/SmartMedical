package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import cn.hachchina.nuaa.smartmedical.R;

import static android.app.PendingIntent.getActivity;


/**
 * Created by Administrator on 2018/5/19.
 */

public class AlarmActivity extends Activity {
    private MediaPlayer mediaPlayer;
    private Button addBtn;
    private EditText nameTxt;
    private EditText freTxt;
    private Calendar c = Calendar.getInstance();
    private int frequency = 1;
//    SharedPreferences preferences = getSharedPreferences("remiderMsg", 0);
//    SharedPreferences.Editor editor = preferences.edit();
//    SharedPreferences.Editor editor = preferences.edit();
//    private PowerManager.WakeLock mWakelock;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_activity_layout);

        addBtn = findViewById(R.id.add_btn);
        nameTxt = findViewById(R.id.name_txt);
        freTxt = findViewById(R.id.frequency_txt);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(AlarmActivity.this, nameTxt.getText().toString() + "每天" + freTxt.getText().toString() + "次", Toast.LENGTH_SHORT).show();
                    setAlarmTime();
            }
        });
    }

    private void setAlarmDate() {

//        final Calendar currentDate = Calendar.getInstance();
//        DatePickerDialog datePickerDialog = new DatePickerDialog(
//                AlarmActivity.this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year,
//                                  int monthOfYear, int dayOfMonth) {
//
//                c.set(Calendar.YEAR, year);
//                c.set(Calendar.MONTH, monthOfYear);
//                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                setAlarmTime(year,monthOfYear,dayOfMonth);
//            }
//        }, currentDate.get(Calendar.YEAR),
//                currentDate.get(Calendar.MONTH),
//                currentDate.get(Calendar.DAY_OF_MONTH));
//        datePickerDialog.show();
    }

    private void setAlarmTime() {
        Calendar currentTime = Calendar.getInstance();
        // 创建一个TimePickerDialog实例，并把它显示出来。

        Intent intent = new Intent(AlarmActivity.this, RingActivity.class);
        PendingIntent pi = getActivity(AlarmActivity.this, 0, intent, 0);
        c.set(Calendar.HOUR_OF_DAY, 8);
        c.set(Calendar.MINUTE, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                c.getTimeInMillis(), (24 / frequency) * 60 * 60 * 60, pi);


        Log.i("TimeInMillis", c.getTimeInMillis() + "");
        // 显示闹铃设置成功的提示信息
        Toast.makeText(AlarmActivity.this, "闹铃设置成功啦",
                Toast.LENGTH_SHORT).show();
        nameTxt.setText("");
        freTxt.setText("");
    }
//        new TimePickerDialog(AlarmActivity.this, 0, // 绑定监听器
//                new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker tp, int hourOfDay,
//                                          int minute) {
////                        // 指定启动AlarmActivity组件
////                        Intent intent = new Intent();
////                        intent.setAction("android.intent.action.MAIN");// Activity
//                        // 创建PendingIntent对象
//                        PendingIntent pi;
//
//                        Intent tempIntent = new Intent(AlarmActivity.this, RingActivity.class);
////                        tempIntent.setAction(AlarmActivity.t);
//                        pi = getActivity(AlarmActivity.this, 0, tempIntent, 0);
//
//
//                        //设置当前时间
////                        Calendar c = Calendar.getInstance();
////                        c.setTimeInMillis(System.currentTimeMillis());
////                        Log.i("TimeInMillis", "TimeInMillis_1"+c.getTimeInMillis()+"");
////                        // 根据用户选择时间来设置Calendar对象
////                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
////                        c.set(Calendar.MINUTE, minute);
//
//
////                        String longTime=year+"-"+(monthOfYear+1)+"-"+dayOfMonth+" "+hourOfDay
////                                + ":" + minute;
////                        Log.i("keke:", longTime);
//
//
//
//                        // 设置AlarmManager将在Calendar对应的时间启动指定组件
//                        // 设置闹钟，当前时间就唤醒
//                        AlarmManager alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
////                        alarmManager.set(AlarmManager.RTC_WAKEUP,
////                                c.getTimeInMillis(), pi);
//                        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
//                                c.getTimeInMillis(), (24/frequency) * 60 * 60 * 60, pi);
//
//
//                        Log.i("TimeInMillis", c.getTimeInMillis()+"");
//                        // 显示闹铃设置成功的提示信息
//                        Toast.makeText(AlarmActivity.this, "闹铃设置成功啦",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
//                .get(Calendar.MINUTE), true).show();
//
////        Intent tempIntent = new Intent();
////        tempIntent.setClass(MainActivity.this, AlarmActivity.class);
////        MainActivity.this.startActivity(tempIntent);
//    }
}
