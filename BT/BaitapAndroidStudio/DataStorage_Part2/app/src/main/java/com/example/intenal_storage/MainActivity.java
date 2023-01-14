package com.example.intenal_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnReadIS = (Button) findViewById(R.id.btn_read);
        Button btnWriteIS = (Button) findViewById(R.id.btn_write);
        TextView tvIS = (TextView) findViewById(R.id.read_text);
        EditText editText = (EditText) findViewById(R.id.write_text);
        AutoCompleteTextView txtAuto = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        btnReadIS.setOnClickListener(new View.OnClickListener() {
            //Bấm nút Read sẽ đọc thông tin từ file ở bộ nhớ trong hiển thị ra
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput("data.txt");
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    String data = new String(buffer);

                    tvIS.setText(data);
                    fis.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnWriteIS.setOnClickListener(new View.OnClickListener() {
            //Bấm nút Write sẽ ghi thông tin xuống file ở bộ nhớ trong
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput("data.txt", MODE_PRIVATE);
                    fos.write((editText.getText() + "").getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        String[] dulieu = {"Quang Nam", "Quang Ngai", "Quang Binh",  "Quang Tri", "Phan Rang", "Phu Quoc"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dulieu);
        txtAuto.setAdapter(adapter);
        txtAuto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                tvIS.setText(txtAuto.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}