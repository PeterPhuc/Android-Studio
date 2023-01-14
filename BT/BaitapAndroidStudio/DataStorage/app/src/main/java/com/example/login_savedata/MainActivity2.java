package com.example.login_savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity2 extends AppCompatActivity {

    TextView txtMsg;
    Button btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtMsg=(TextView) findViewById(R.id.txtmsg);
        btnThoat=(Button) findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent i = getIntent();
        txtMsg.setText("Hello : " + i.getStringExtra("user"));
    }
}