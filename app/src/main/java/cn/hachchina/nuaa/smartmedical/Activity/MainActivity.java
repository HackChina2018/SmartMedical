package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;


import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;


import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


import cn.hachchina.nuaa.smartmedical.Bean.UserBean;
import cn.hachchina.nuaa.smartmedical.Bean.ViewBean_MainActivity;
import cn.hachchina.nuaa.smartmedical.R;
import cn.hachchina.nuaa.smartmedical.Util.FileUtil;
import cn.hachchina.nuaa.smartmedical.Util.VerifyPermissionUtil;

//import static android.app.PendingIntent.getActivity;
import static android.app.PendingIntent.getActivity;
import static cn.hachchina.nuaa.smartmedical.Util.CallPhoneUtil.call;

public class MainActivity extends Activity {

    private ViewBean_MainActivity views;
    Calendar c = Calendar.getInstance();
    private AlertDialog dlgSpecItem;
    private View specItemView;
    private PendingIntent pi;
    private ListView lv;
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

        LayoutInflater inflater = LayoutInflater.from(this);

        specItemView = inflater.inflate(R.layout.spec_list_view, null);
//        ScrollView sv = (ScrollView) specItemView.findViewById(R.id.spec_sv);
//        sv.smoothScrollTo(0,0);
        lv = (ListView) specItemView.findViewById(R.id.spec_item_list);

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
        views.IV_SetRing = findViewById(R.id.set_ring);

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

        views.IV_SetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarmDate();

            }
        });

        views.IV_SetRing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String path = Environment.getDataDirectory().getAbsolutePath() + "/";
                String path = Environment.getExternalStorageDirectory() + "/";
                Log.i("path:", path);
                File[] files = FileUtil.getFiles(path);
                if(files == null) {
                    Log.i("error:", "empty");
                } else {
                    mapLayout(files);
                }
            }

        });


    }

    private void mapLayout(final File[] files) {
        List<HashMap<String, Object>> specs = new ArrayList<HashMap<String,Object>>();
        int seq = 0;
        for(File spec : files){
            seq++;
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("seq", seq);
            hashMap.put("name", spec.getName());
//            Log.i("path2", spec.getName());
            specs.add(hashMap);
        }

        SimpleAdapter adapter =
                new SimpleAdapter(
                        this,
                        specs,
                        R.layout.spec_item_list,
                        new String[]{"seq","name"},
                        new int[]{R.id.spec_item_seq, R.id.spec_item_name}
                );
//        Log.i("path:", "test");
        lv.setAdapter(adapter);

//        lv.setOnItemClickListener();
//        lv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String filePath = files[i].getAbsolutePath();
//                Intent intent = new Intent();
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.setAction(Intent.ACTION_VIEW);
//                File file = new File(filePath);
////                Uri uri = getUri(intent, file);
////                intent.setDataAndType(uri, dataType);
//            }

//            @Override
//            public void onClick(View view) {
//
//            }
//        });

//        lv.setOnClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String filePath = files[i].getAbsolutePath();
//                Log.i("item","i");
////                Intent intent = getWordFileIntent(filePath);
////                startActivity(intent);
//            }
//        });

        if(dlgSpecItem != null){
            dlgSpecItem.setView(null);
        }
        if(specItemView.getParent() != null){
            ((FrameLayout)specItemView.getParent()).removeView(specItemView);
        }

        dlgSpecItem = new AlertDialog.Builder(MainActivity.this)
                .setView(specItemView)
                .show();

        dlgSpecItem.setCanceledOnTouchOutside(true);
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
                        pi = getActivity(MainActivity.this, 0, tempIntent, 0);


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


}
