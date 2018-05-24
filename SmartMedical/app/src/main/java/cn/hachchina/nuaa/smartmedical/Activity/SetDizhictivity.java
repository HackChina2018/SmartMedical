package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.hachchina.nuaa.smartmedical.ActivityManager.ActivityManager;
import cn.hachchina.nuaa.smartmedical.R;


/**
 * Created by DMRF on 2017/8/9.
 */

public class SetDizhictivity extends Activity {



    private EditText dizhi;
    private Button setting_name_cancel;
    private Button setting_name_sure;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setdizhi);
        ActivityManager.getInstance().addActivity(SetDizhictivity.this);


        initViews();
        initListener();



    }

    private void initListener() {
        setting_name_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetDizhictivity.this.finish();
            }
        });

        setting_name_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String n = dizhi.getText().toString();

                    MainActivity.userBean.setDizhi(n);
                    Toast.makeText(SetDizhictivity.this,"设定个人地址成功!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SetDizhictivity.this, MainActivity.class);
                    startActivity(intent);
                    SetDizhictivity.this.finish();
            }
        });


    }

    private void initViews() {


        dizhi=findViewById(R.id.setdizhi);

        setting_name_cancel = findViewById(R.id.setting_name_cancel);
        setting_name_sure = findViewById(R.id.setting_name_sure);

    }
}
