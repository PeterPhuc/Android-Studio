package com.example.gamesetting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    RadioButton btn1, btn2, btn3;
    SeekBar bar1, bar2;
    Button saveChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("Text.txt", MODE_PRIVATE);
        editor = sp.edit();
        btn1 = (RadioButton) findViewById(R.id.radioButton1);
        btn2 = (RadioButton) findViewById(R.id.radioButton2);
        btn3 = (RadioButton) findViewById(R.id.radioButton3);
        bar1 = (SeekBar) findViewById(R.id.seekBar1);
        bar2 = (SeekBar) findViewById(R.id.seekBar2);
        saveChange = (Button) findViewById(R.id.saveBtn);

        saveChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savingPreferences();
//                finish();
            }
        });
    }

    @Override
    protected void onResume() {        //Khởi chạy hàm này khi vừa bật app lên
        super.onResume();
        restoringPreferences();
    }

    private void restoringPreferences() {                //Truy xuất dữ liệu đã lưu
        SharedPreferences pre = this.getSharedPreferences("Text", MainActivity.MODE_PRIVATE);
        String seekbar1 = pre.getString("seekbar1", "");
        String seekbar2 = pre.getString("seekbar2", "");
        String radioText = pre.getString("radioText", "");

        bar1.setProgress(Integer.parseInt(seekbar1));
        bar2.setProgress(Integer.parseInt(seekbar2));

        if(btn1.getText().toString().equals(radioText)) {
            btn1.setChecked(true);
        }else if(btn2.getText().toString().equals(radioText)){
            btn2.setChecked(true);
        }else if(btn3.getText().toString().equals(radioText)){
            btn3.setChecked(true);
        }
    }

    private void savingPreferences(){          //Lưu
        SharedPreferences pre = this.getSharedPreferences("Text", MainActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();

        String seekbar1 = String.valueOf( bar1.getProgress() );
        String seekbar2 = String.valueOf( bar2.getProgress() );
        String getTextRadio = "";

        if(btn1.isChecked()){
            getTextRadio = btn1.getText().toString();
        }else if(btn2.isChecked()){
            getTextRadio = btn2.getText().toString();
        }else if(btn3.isChecked()){
            getTextRadio = btn3.getText().toString();
        }
        editor.putString("seekbar1", seekbar1);
        editor.putString("seekbar2", seekbar2);
        editor.putString("radioText", getTextRadio);
        editor.commit();
        Toast.makeText(MainActivity.this, "Đã lưu", Toast.LENGTH_SHORT).show();
    }
}