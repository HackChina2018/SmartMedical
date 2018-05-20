package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;


import cn.hachchina.nuaa.smartmedical.R;


/**
 * Created by DMRF on 2017/8/8.
 */

public class GerenzhongxinActivity extends Activity {
    private Button xingming;
    private Button zhuzhi;
    private Button jinjilianxiren;

    private Button exit_login;
    private Button bingli;
    private Button yongyaotixing;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userself_layout);
        initViews();
        initListener();
    }

    private void initListener() {

        zhuzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(GerenzhongxinActivity.this, SetDizhictivity.class);
                GerenzhongxinActivity.this.startActivity(intent);
            }
        });
        jinjilianxiren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!MainActivity.userBean.isIsset()){
                    Intent intent = new Intent();
                    intent.setClass(GerenzhongxinActivity.this, SetJinJilianxirenActivity.class);
                    intent.putExtra("type", "in");
                    GerenzhongxinActivity.this.startActivity(intent);
                }else {

                }
            }
        });
        yongyaotixing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(GerenzhongxinActivity.this, Addyongyaotixing.class);
                GerenzhongxinActivity.this.startActivity(intent);
            }
        });
    }

    private void initViews() {
        xingming = findViewById(R.id.jinji_xingming);
        zhuzhi = findViewById(R.id.zhuzhi);
        jinjilianxiren = findViewById(R.id.jinjilianxiren_xingming);
        exit_login = findViewById(R.id.tuichudenglu);
        bingli = findViewById(R.id.bingli);
        yongyaotixing = findViewById(R.id.yongyaotixing);
    }

}
