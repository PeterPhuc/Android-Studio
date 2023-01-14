package com.example.call_log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.readBtn);
        listView = findViewById(R.id.listview1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG}, PackageManager.PERMISSION_GRANTED);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCallLog();
            }
        });

    }

    public void loadCallLog() {

        String stringOutput = "";
        Uri uri = CallLog.Calls.CONTENT_URI;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Cursor c = getContentResolver().query(uri, null, null, null, null);

        c.moveToFirst();

        do {
            int rowNumber = c.getColumnIndex(CallLog.Calls.NUMBER);
            int rowName = c.getColumnIndex(CallLog.Calls.CACHED_NAME);
            int rowDuration = c.getColumnIndex(CallLog.Calls.DURATION);
            int rowType = c.getColumnIndex(CallLog.Calls.TYPE);

            String stringNumber = c.getString(rowNumber);
            String stringName = c.getString(rowName);
            String stringDuration = c.getString(rowDuration);
            String stringType = c.getString(rowType);
            if (stringName.equals("")){
                stringName = "Unknown";
            }

            stringOutput = stringOutput + "Number: " + stringNumber
                    + "\nName: " + stringName
                    + "\nDuration: " + stringDuration
                    + "\nType: " + stringType
                    + "\n\n";

        }while ( c.moveToNext() );
        listView.setText(stringOutput);
    }
}