package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import cn.hachchina.nuaa.smartmedical.R;


/**
 * Created by lenovo on 2016/6/1.
 */
public class A_jbzz_toutong extends Activity {
    String TAG = "A_jbzz_toutong";
    List<String> listSym = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.jbzz_toutong);
        super.onCreate(savedInstanceState);

        Button bt_jbcc = (Button) findViewById(R.id.bt_jbcc);
        bt_jbcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(A_jbzz_toutong.this, MaiYao.class);
                startActivity(intent);
            }
        });
    }
}
