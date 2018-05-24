package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.hachchina.nuaa.smartmedical.R;

public class ShuomingshuActivity extends Activity {
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shuomingshu_layout);
        editText = findViewById(R.id.shurudeyaopin);

        findViewById(R.id.baijiahei).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShuomingshuActivity.this, BaijiaheiShuomingshuActivity.class);
                ShuomingshuActivity.this.startActivity(intent);
            }
        });

        findViewById(R.id.chaxunshuruyaopin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String te = String.valueOf(editText.getText());
                if (te.contains("健胃")) {
                    Intent intent = new Intent();
                    intent.setClass(ShuomingshuActivity.this, JainweixiaoshipianShuomingshuActivity.class);
                    ShuomingshuActivity.this.startActivity(intent);
                } else {
                    Toast.makeText(ShuomingshuActivity.this, "药品名错误", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
