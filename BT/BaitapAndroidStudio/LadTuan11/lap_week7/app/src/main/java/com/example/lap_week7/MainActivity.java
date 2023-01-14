package com.example.lap_week7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    ListView listView;
    Button readBtn;
    ArrayList<Contacts> list;
    ArrayAdapter<Contacts> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview1);
        readBtn = findViewById(R.id.readBtn);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<Contacts>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readContact();
            }
        });


    }
    public void readContact(){

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        list.clear();
        cursor.moveToFirst();
        while ( cursor.moveToNext() ){

            String colPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int rowPhone = cursor.getColumnIndex(colPhone);
            String phone = cursor.getString(rowPhone);


            String colName = ContactsContract.Contacts.DISPLAY_NAME;
            int rowName = cursor.getColumnIndex(colName);
            String name = cursor.getString(rowName);


            Contacts contacts = new Contacts( name, phone);
            list.add(contacts);
            adapter.notifyDataSetChanged();
        }
    }
}
