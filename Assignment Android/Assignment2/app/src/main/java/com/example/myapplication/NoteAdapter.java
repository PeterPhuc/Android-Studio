package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;

import io.realm.Realm;
import io.realm.RealmResults;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    RealmResults<Note> notes;
    Context context;

    public NoteAdapter(Context context, RealmResults<Note> notes) {
        this.notes = notes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.title.setText(note.getTitle());
        holder.description.setText(note.getDescription());

        String formattedTime = DateFormat.getDateTimeInstance().format(note.createdTime);
        holder.createdTime.setText(formattedTime);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu = new PopupMenu(context, v);
                menu.getMenu().add("Xóa Note");
                menu.getMenu().add("Chỉnh sửa note");
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().equals("Xóa Note")){
                            Realm realm = Realm.getDefaultInstance();
                            realm.beginTransaction();
                            note.deleteFromRealm();
                            realm.commitTransaction();

                            Toast.makeText(context, "Đã xóa note", Toast.LENGTH_LONG).show();
                        }else{
                            Intent i = new Intent(context, editNote.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i.putExtra("title", note.getTitle());
                            i.putExtra("des", note.getDescription());
                            i.putExtra("position", String.valueOf(position));
                            context.startActivity(i);
                        }
                        return true;
                    }
                });
                menu.show();
                //return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView createdTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleOutput);
            description = itemView.findViewById(R.id.descriptionOutput);
            createdTime = itemView.findViewById(R.id.createdTimeOutput);
        }
    }
}
