package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.hachchina.nuaa.smartmedical.R;


public class JBZZActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.jbzz_main);
        super.onCreate(savedInstanceState);
        Button but_tt = (Button) findViewById(R.id.bt_toutong);
        but_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JBZZActivity.this, A_jbzz_toutong.class);
                startActivity(intent);
            }
        });

    }
}
