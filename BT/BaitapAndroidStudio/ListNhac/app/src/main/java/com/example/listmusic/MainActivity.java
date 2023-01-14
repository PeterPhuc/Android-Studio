package com.example.listmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Singer> listSinger;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listNhac);
        listSinger = new ArrayList<>();

        listSinger.add(new Singer(R.drawable.lebaobinh, "Lê Bảo Bình", "*989K quan tâm"));
        listSinger.add(new Singer(R.drawable.datlongvinh, "Đạt Long Vinh", "*3K quan tâm"));
        listSinger.add(new Singer(R.drawable.adele, "Adele", "*24K quan tâm"));

        customAdapter = new CustomAdapter(MainActivity.this, R.layout.layout_items_singer, listSinger);
        listView.setAdapter(customAdapter);


        ArrayList<listNhac> listLBB;
        listLBB = new ArrayList<>();
        listLBB.add(new listNhac("Lá Xa Lìa Cành", R.drawable.lebaobinh, "Lê Bảo Bình"));
        listLBB.add(new listNhac("Cuộc Vui Cô Đơn", R.drawable.lebaobinh, "Lê Bảo Bình"));
        listLBB.add(new listNhac("Thích Thì Đến", R.drawable.lebaobinh, "Lê Bảo Bình"));
        listLBB.add(new listNhac("Bước Qua Đời Nhau", R.drawable.lebaobinh, "Lê Bảo Bình"));


        ArrayList<listNhac> listDLV;
        listDLV = new ArrayList<>();
        listDLV.add(new listNhac("Pháo Hồng", R.drawable.datlongvinh, "Đạt Long Vinh"));
        listDLV.add(new listNhac("Dã Quỳ", R.drawable.datlongvinh, "Đạt Long Vinh"));
        listDLV.add(new listNhac("Tình Xuân Ca", R.drawable.datlongvinh, "Đạt Long Vinh"));



        ArrayList<listNhac> listADL;
        listADL = new ArrayList<>();
        listADL.add(new listNhac("Hello", R.drawable.adele, "Adele"));
        listADL.add(new listNhac("Easy On Me", R.drawable.adele, "Adele"));
        listADL.add(new listNhac("Someone Like You", R.drawable.adele, "Adele"));
        listADL.add(new listNhac("To Be Loved", R.drawable.adele, "Adele"));
        listADL.add(new listNhac("My Same", R.drawable.adele, "Adele"));



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle b = new Bundle();

                Singer singer = customAdapter.getItem(i);
                String singer_name = singer.getName();
                switch (singer_name) {
                    case "Lê Bảo Bình":
                        b.putSerializable("key", (Serializable) listLBB);
                        break;

                    case "Đạt Long Vinh":
                        b.putSerializable("key", (Serializable) listDLV);
                        break;

                    case "Adele":
                        b.putSerializable("key", (Serializable) listADL);
                        break;
                }
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}