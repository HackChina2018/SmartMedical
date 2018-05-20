package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import cn.hachchina.nuaa.smartmedical.R;

import static android.app.PendingIntent.getActivity;


/**
 * Created by Administrator on 2018/5/19.
 */

public class AlarmActivity extends Activity {
//    private MediaPlayer mediaPlayer;
    private Button addBtn;
    private Button cancleBtn;
    private EditText nameTxt;
    private EditText freTxt;
    private Calendar c = Calendar.getInstance();
    private int frequency = 1;
    private AlarmManager alarmManager;
    private PendingIntent pi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_activity_layout);

        addBtn = findViewById(R.id.add_btn);
        nameTxt = findViewById(R.id.name_txt);
        freTxt = findViewById(R.id.frequency_txt);
        cancleBtn = findViewById(R.id.cancle_btn);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(AlarmActivity.this, RingActivity.class);
        pi = getActivity(AlarmActivity.this, 0, intent, 0);

        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(AlarmActivity.this, RingActivity.class);
//                PendingIntent pit = PendingIntent.getActivity(AlarmActivity.this);
//                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.cancel(pi);
                Toast.makeText(AlarmActivity.this, "the alarm is cancle", Toast.LENGTH_SHORT).show();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(AlarmActivity.this, nameTxt.getText().toString() + "每天" + freTxt.getText().toString() + "次", Toast.LENGTH_SHORT).show();
                    setAlarmTime();
            }
        });
    }

    private void setAlarmTime() {
        Calendar currentTime = Calendar.getInstance();
        // 创建一个TimePickerDialog实例，并把它显示出来。


        c.set(Calendar.HOUR_OF_DAY, 8);
        c.set(Calendar.MINUTE, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                c.getTimeInMillis(), 600, pi);


        Log.i("TimeInMillis", c.getTimeInMillis() + "");
        // 显示闹铃设置成功的提示信息
        Toast.makeText(AlarmActivity.this, "闹铃设置成功啦",
                Toast.LENGTH_SHORT).show();
        nameTxt.setText("");
        freTxt.setText("");
    }
}
