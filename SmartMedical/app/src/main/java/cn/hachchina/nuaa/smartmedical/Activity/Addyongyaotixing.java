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

public class Addyongyaotixing extends Activity {




    private Button ok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yongyaotixing);
        ActivityManager.getInstance().addActivity(Addyongyaotixing.this);

        initViews();
        initListener();



    }

    private void initListener() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Addyongyaotixing.this.finish();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                    Intent intent = new Intent(Addyongyaotixing.this, MainActivity.class);
//                    startActivity(intent);
//                    Addyongyaotixing.this.finish();
            }
        });


    }

    private void initViews() {


        ok=findViewById(R.id.yongyaotixingok);


    }
}
