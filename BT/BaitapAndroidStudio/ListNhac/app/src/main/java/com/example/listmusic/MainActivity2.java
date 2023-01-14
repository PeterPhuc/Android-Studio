package com.example.listmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    CustomAdapterListSong Cals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        ArrayList<listNhac> listsong = (ArrayList<listNhac>) b.getSerializable("key");


        listView = (ListView) findViewById(R.id.listNhac);

        Cals = new CustomAdapterListSong(MainActivity2.this, R.layout.layout_items_listsong, listsong);
        listView.setAdapter(Cals);
    }
}