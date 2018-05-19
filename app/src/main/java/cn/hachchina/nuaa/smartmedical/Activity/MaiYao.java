package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


import cn.hachchina.nuaa.smartmedical.R;

public class MaiYao extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toutong_result);
        findViewById(R.id.bt_ok_toutong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MaiYao.this)
                        .setIcon(R.drawable.ic_icon_second)
                        .setTitle("购买成功")
                        .setMessage(
                                "您的药品已购买成功，预计1小时内送到，本应用已自动为您设定吃药提醒，祝您早日康复～")
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int whichButton) {

                                        Intent intent = new Intent();
                                        intent.setClass(MaiYao.this, MainActivity.class);
                                        MaiYao.this.startActivity(intent);
                                    }
                                }).create().show();
            }

        });
    }


}
