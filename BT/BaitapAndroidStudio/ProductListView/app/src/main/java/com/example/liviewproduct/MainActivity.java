package com.example.liviewproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<product> listProduct;
    CustomAdapter customAdapter;

    ImageView arrowTop, arrowDown;
    TextView price, soluong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listProduct);
        listProduct = new ArrayList<>();
        listProduct.add(new product(R.drawable.ao, "Áo Thun Xanh Nam", "20.000đ", "20.000đ"));
        listProduct.add(new product(R.drawable.quan, "Quần Jean Nữ", "50.000đ", "50.000đ"));

        customAdapter = new CustomAdapter(MainActivity.this, R.layout.items_product, listProduct);
        listView.setAdapter(customAdapter);

        arrowTop = (ImageView) findViewById(R.id.nutTang);
        arrowDown = (ImageView) findViewById(R.id.nutGiam);
        price = (TextView) findViewById(R.id.giasp);
        soluong = (TextView) findViewById(R.id.soluong);
    }


}