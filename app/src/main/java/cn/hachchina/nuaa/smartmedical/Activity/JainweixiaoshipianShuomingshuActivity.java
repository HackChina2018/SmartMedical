package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import cn.hachchina.nuaa.smartmedical.R;


public class JainweixiaoshipianShuomingshuActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jianweixaoshipianshuomingshu);

        findViewById(R.id.goumaixiaoshipian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(JainweixiaoshipianShuomingshuActivity.this)
                        .setIcon(R.drawable.logo)
                        .setTitle("购买成功")
                        .setMessage(
                                "药品江中牌健胃消食片已购买成功，预计40分钟送到，本应用已自动为您设定吃药提醒，祝您早日康复～")
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int whichButton) {

                                        Intent intent = new Intent();
                                        intent.setClass(JainweixiaoshipianShuomingshuActivity.this, MainActivity.class);
                                        JainweixiaoshipianShuomingshuActivity.this.startActivity(intent);
                                    }
                                }).create().show();
            }
        });
    }
}
