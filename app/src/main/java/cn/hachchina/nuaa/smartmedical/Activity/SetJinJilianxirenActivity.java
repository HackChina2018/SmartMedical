package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.hachchina.nuaa.smartmedical.ActivityManager.ActivityManager;
import cn.hachchina.nuaa.smartmedical.R;


/**
 * Created by DMRF on 2017/8/9.
 */

public class SetJinJilianxirenActivity extends Activity {


    private EditText name;
    private EditText tel;
    private EditText relation;
    private Button setting_name_cancel;
    private Button setting_name_sure;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setzhuzhi);
        ActivityManager.getInstance().addActivity(SetJinJilianxirenActivity.this);


        initViews();
        initListener();



    }

    private void initListener() {
        setting_name_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetJinJilianxirenActivity.this.finish();
            }
        });

        setting_name_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String n = name.getText().toString();
                    String r = relation.getText().toString();
                    String t = tel.getText().toString();
                    MainActivity.userBean.setEmergencyContact_Name(n);
                    MainActivity.userBean.setGuanxi(r);
                    MainActivity.userBean.setEmergencyContact_Numer(t);
                    Toast.makeText(SetJinJilianxirenActivity.this,"添加紧急联系人成功!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SetJinJilianxirenActivity.this, MainActivity.class);
                    startActivity(intent);
                    SetJinJilianxirenActivity.this.finish();
            }
        });


    }

    private void initViews() {

        name = findViewById(R.id.setting_name_newname);
        relation = findViewById(R.id.setting_guanxi);
        tel = findViewById(R.id.setting_dainhua);
        setting_name_cancel = findViewById(R.id.setting_name_cancel);
        setting_name_sure = findViewById(R.id.setting_name_sure);

    }
}
