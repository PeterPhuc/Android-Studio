package com.example.listviewcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Country> listCountry;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listQuocGia);

        listCountry = new ArrayList<>();
        listCountry.add(new Country(R.drawable.viet_flag, "VietNam", "98000000"));
        listCountry.add(new Country(R.drawable.usa_flag, "United States", "320000000"));
        listCountry.add(new Country(R.drawable.russia_flag, "Russia", "142000000"));

        customAdapter = new CustomAdapter(MainActivity.this, R.layout.item_country, listCountry);

        listView.setAdapter(customAdapter);


    }
}