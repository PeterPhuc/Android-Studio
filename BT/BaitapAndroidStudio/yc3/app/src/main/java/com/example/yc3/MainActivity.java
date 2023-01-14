package com.example.yc3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button apply_btn;
    RadioButton hn, dn, sg, dl;
    ImageView change_img;
    RadioGroup rd_group;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        rd_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                change_img.setVisibility(View.INVISIBLE);
                int checkedRadioId = group.getCheckedRadioButtonId();

                if(checkedRadioId== R.id.check_dalat) {
                    change_img.setImageResource(R.drawable.img_dl);
                } else{
                    change_img.setImageResource(R.drawable.img_sg);
                }
            }
        });
        apply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_img.setVisibility(View.VISIBLE);
            }
        });
    }
    private void init(){
        apply_btn = (Button) findViewById(R.id.apply_btn);
        dl = (RadioButton) findViewById(R.id.check_dalat);
        change_img = (ImageView) findViewById(R.id.cityImg);
        rd_group = (RadioGroup) findViewById(R.id.rd_group);
    }
}