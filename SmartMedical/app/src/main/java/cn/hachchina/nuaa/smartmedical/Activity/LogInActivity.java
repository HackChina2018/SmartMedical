package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.hachchina.nuaa.smartmedical.R;

public class LogInActivity extends Activity {
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);
        init();
    }

    private void init() {
        login = findViewById(R.id.login);
        username = findViewById(R.id.editUserName);
        password = findViewById(R.id.editPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(username.getText());
                String pass = String.valueOf(password.getText());

                if (name.equals("demo") && pass.equals("demo")) {
                    Intent tempIntent = new Intent();
                    tempIntent.setClass(LogInActivity.this, MainActivity.class);
                    LogInActivity.this.startActivity(tempIntent);

                }
            }
        });
    }
}
