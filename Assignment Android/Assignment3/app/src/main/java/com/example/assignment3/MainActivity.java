package com.example.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.Normalizer;
import java.util.Objects;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    static final String[] listnewsitem = new String[]{"THẾ GIỚI", "THỜI SỰ", "KINH DOANH", "GIẢI TRÍ","THỂ THAO", "KHOA HỌC", "GIÁO DỤC", "SỨC KHỎE", "CƯỜI", "TÂM SỰ"};
    static final String[] listlinkrss = new String[]{"the-gioi", "thoi-su", "kinh-doanh", "giai-tri", "the-thao", "khoa-hoc", "giao-duc", "suc-khoe", "cuoi", "tam-su"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listnewsitem);
        ListView lv = findViewById(R.id.testList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  String url = "https://vnexpress.net/rss/" + listlinkrss[i] + ".rss";
                  Intent intent = new Intent(MainActivity.this, NewsItemActivity.class);
                  intent.putExtra("url", url);
                  startActivity(intent);
                  
            }
        });
    }

//    @Nullable
//    public static String covertToString(String value) {
//        try {
//            String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
//            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//            return pattern.matcher(temp).replaceAll("");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
}