package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class editNote extends AppCompatActivity {
    Toolbar toolbar;
    EditText txtTitle, txtDes;
    String title,des;
    long createdTime;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_edit);

        Intent i = getIntent();
        title = i.getStringExtra("title");
        des = i.getStringExtra("des");
        position = Integer.parseInt(i.getStringExtra("position"));

        txtTitle = findViewById(R.id.titleInput);
        txtDes = findViewById(R.id.descriptionInput);
        txtTitle.setText(title);
        txtDes.setText(des);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item.getItemId() == R.id.save ){
            Save();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert_dialog_build = new AlertDialog.Builder(this);
        alert_dialog_build.setMessage("Tiếp tục edit hay thoát ???");

        alert_dialog_build.setNegativeButton("Continue Edit",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alert_dialog_build.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });

        AlertDialog alert = alert_dialog_build.create();
        alert.show();

//        super.onBackPressed();
    }

    public void Save() {
        title = txtTitle.getText().toString();
        des = txtDes.getText().toString();

        if(title.equals("") || des.equals("")){
            Toast.makeText(getApplicationContext(), "Bạn không được bỏ trống Title và Description!!!", Toast.LENGTH_SHORT).show();
        }

        else {
            Realm.init(getApplicationContext());
            Realm realm = Realm.getDefaultInstance();

            realm.beginTransaction();

            if(position >= 0){
                RealmResults<Note> notes = realm.where(Note.class).findAll().sort("createdTime", Sort.DESCENDING);;
                Note noteDel = notes.get(position);
                noteDel.deleteFromRealm();
            }

            Note note = realm.createObject(Note.class);
            createdTime = System.currentTimeMillis();
            note.setTitle(title);
            note.setDescription(des);
            note.setCreatedTime(createdTime);

            realm.commitTransaction();


            Toast.makeText(getApplicationContext(), "Đã lưu note", Toast.LENGTH_LONG).show();
            finish();      //chuyển sang main activity
        }
    }
}