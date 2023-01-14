package com.example.baitap1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SeekBar skb;
    TextView tv1, tv2, tv3, tv4, tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);

        skb = findViewById(R.id.slider);
        skb.setMax(100);

        skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if (progress == 0) {
                    tv1.setBackgroundColor(Color.rgb(155, 10, 10));
                    tv2.setBackgroundColor(Color.rgb(252, 231, 0));
                    tv3.setBackgroundColor(Color.rgb(234, 4, 126));
                    tv4.setBackgroundColor(Color.rgb(192, 122, 255));
                    tv5.setBackgroundColor(Color.rgb(80, 255, 212));
                } else {
                    tv1.setBackgroundColor(Color.rgb(155 + progress, 10 + progress, 10));
                    tv2.setBackgroundColor(Color.rgb(252 - progress, 231 - progress, 0 + progress));
                    tv3.setBackgroundColor(Color.rgb(234 - progress, 4, 126 + progress));
                    tv4.setBackgroundColor(Color.rgb(192 - progress, 122 + progress, 255));
                    tv5.setBackgroundColor(Color.rgb(80 + progress, 255 - progress, 212));
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {        //Khởi tạo 1 menu 3 chấm
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {               //AlertDialog.Builder là lớp nội bộ của AlertDialog
        switch(item.getItemId()) {     //Chọn vào item của menu
            case R.id.more_info:       //Nếu bấm trúng item có id là more_info
                    AlertDialog.Builder alert_dialog_build = new AlertDialog.Builder(this);                   //Khởi tạo 1 dialog
                    alert_dialog_build.setMessage("Xin chào, mình là Lê Trung Tín");                                 //Đặt message cho dialog

                    alert_dialog_build.setNegativeButton("Not Now",new DialogInterface.OnClickListener() {      //thiết lập tùy chọn cancel
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    alert_dialog_build.setPositiveButton("Visit android course", new DialogInterface.OnClickListener() {  //thiết lập tùy chọn đồng ý
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            //intent ngầm định
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://khoapham.vn/khoa-hoc-lap-trinh-android.html"));
                            startActivity(intent);
                        }
                    });

                    //Sau khi thiết lập xong 1 dialog builder, tạo 1 alert dialog để show nó lên màn hình
                    AlertDialog alert = alert_dialog_build.create();           //Tạo hộp thoại dialog
                    alert.show();
                    return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}