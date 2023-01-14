package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    StudentDB studentdb;
    ArrayAdapter<String> adapter;
    ArrayList<Student> arrayStudent;
    ArrayList<Student> arrayStudent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText mssv = findViewById(R.id.mssv);
        EditText hoten = findViewById(R.id.hoten);
        EditText malop = findViewById(R.id.malop);
        Button btnThem = findViewById(R.id.btn_them);
        Button btnSua = findViewById(R.id.btn_sua);
        Button btnXoa = findViewById(R.id.btn_xoa);
        Button btnXemdssv = findViewById(R.id.btn_showDSSV);


        //Tạo db
        studentdb = new StudentDB(this, "StudentData.sqlite", null, 1);
        studentdb.QueryData("CREATE TABLE IF NOT EXISTS Student (Mssv TEXT PRIMARY KEY, Ten TEXT, Malop TEXT)");

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String getmssv = "'" + mssv.getText().toString() + "'";
                    String getten = "'" + hoten.getText().toString() + "'";
                    String getmalop = "'" + malop.getText().toString() + "'";

                    String query = "INSERT INTO Student VALUES ("+ getmssv + "," + getten + "," + getmalop + ")";
                    studentdb.QueryData(query);
                    showListStudent();
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String getmssv = "'" + mssv.getText().toString() + "'";
                    String getten = "'" + hoten.getText().toString() + "'";
                    String getmalop = "'" + malop.getText().toString() + "'";

                    String query = "DELETE FROM Student where Mssv = " + getmssv + " and Ten = " + getten;

                    studentdb.QueryData(query);
                    showListStudent();
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String getmssv = "'" + mssv.getText().toString() + "'";
                    String getten = "'" + hoten.getText().toString() + "'";
                    String getmalop = "'" + malop.getText().toString() + "'";

                    String query = "UPDATE Student\n" +
                                   "SET Mssv = " + getmssv + ", Ten = " + getten + ", Malop = " + getmalop + "\n" + 
                                   "WHERE Mssv = " + getmssv;

                    studentdb.QueryData(query);
                    showListStudent();
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXemdssv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showListStudent();
            }
        });
    }

    public void showListStudent(){
        ListView lv = findViewById(R.id.listStudent);
        arrayStudent = new ArrayList<>();

        Cursor dataStudent = studentdb.getData("SELECT * FROM student");
        while(dataStudent.moveToNext()){
            String getMSSV = dataStudent.getString(0);
            String getTen = dataStudent.getString(1);
            String getMaLop = dataStudent.getString(2);
            arrayStudent.add(new Student(getMSSV, getTen, getMaLop));
        }

        int lenOfArrayStudent = arrayStudent.size();

        String[] str = new String[lenOfArrayStudent];
        for(int i = 0; i < lenOfArrayStudent; i++){
            str[i] = arrayStudent.get(i).ConvertToString();
        }
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, str);
        lv.setAdapter(adapter);
    }
}