package com.example.quanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Student> arrayStudent;

    public StudentAdapter(Context context, int layout, ArrayList<Student> arrayStudent) {
        this.context = context;
        this.layout = layout;
        this.arrayStudent = arrayStudent;
    }
    @Override
    public int getCount() {
        return arrayStudent.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layout, null);
        return null;
    }
}
