package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<infoBaiHat> listNhac;
    CustomViewAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listNhac);

        listNhac = new ArrayList<>();
        listNhac.add(new infoBaiHat(R.drawable.adele, "Someone Like You", "adele", "4:47"));
        listNhac.add(new infoBaiHat(R.drawable.noopt, "Gạt đi nước mắt", "Noo Phước Thịnh", "3:45"));
        listNhac.add(new infoBaiHat(R.drawable.tuanhung, "Tìm lại bầu trời", "Tuấn Hưng", "5:23"));

        customAdapter = new CustomViewAdapter(MainActivity.this, R.layout.items_song, listNhac);

        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                infoBaiHat BaiHatNay = customAdapter.getItem(i);
                Toast.makeText(MainActivity.this, BaiHatNay.getNameSong(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}