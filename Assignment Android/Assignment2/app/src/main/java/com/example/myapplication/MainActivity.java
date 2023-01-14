package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;
import io.realm.exceptions.RealmMigrationNeededException;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.note_recyclerview);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Note> notes = realm.where(Note.class).findAll().sort("createdTime", Sort.DESCENDING);
        //truy vấn đối tượng note, và sắp xếp theo thời gian giảm dần, trả về 1 list kq dưới dạng RealmResult Object

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        NoteAdapter noteAdapter = new NoteAdapter(getApplicationContext(), notes);
        recyclerView.setAdapter(noteAdapter);

        notes.addChangeListener(new RealmChangeListener<RealmResults<Note>>() {
            @Override
            public void onChange(RealmResults<Note> notes) {
                noteAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add){
            Intent i = new Intent(MainActivity.this, editNote.class);
            i.putExtra("title", "");
            i.putExtra("des", "");
            i.putExtra("position", "-1");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}