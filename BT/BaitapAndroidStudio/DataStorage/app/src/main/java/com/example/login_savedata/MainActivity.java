package com.example.login_savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    EditText username, password;
    Button login;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("Text.txt", MODE_PRIVATE);
        editor = sp.edit();

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        checkBox = (CheckBox) findViewById(R.id.checkbox_id);
        login = (Button) findViewById(R.id.loginbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savingPreferences();
                finish();
                Intent mh = new Intent(MainActivity.this, MainActivity2.class);
                mh.putExtra("user", username.getText().toString());
                startActivity(mh);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        savingPreferences();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoringPreferences();
    }

    private void restoringPreferences() {
        SharedPreferences pre = this.getSharedPreferences("Text",
                MainActivity.MODE_PRIVATE);
        if(pre != null) {
            boolean bchk = pre.getBoolean("checked", false);
            if (bchk) {
                String user = pre.getString("user", "admin");
                String pwd = pre.getString("pwd", "123");
                username.setText(user);
                password.setText(pwd);
            }
            checkBox.setChecked(bchk);
        }
    }

    private void savingPreferences(){
        SharedPreferences pre = this.getSharedPreferences("Text", MainActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        String user = username.getText().toString();
        String pwd = password.getText().toString();
        boolean bchk = checkBox.isChecked();
        if(!bchk)
        {
            editor.clear();
        }
        else
        {
            editor.putString("user", user);
            editor.putString("pwd", pwd);
            editor.putBoolean("checked", bchk);
        }
        editor.commit();
    }
}