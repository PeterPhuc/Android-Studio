package com.example.listmusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapterListSong extends ArrayAdapter<listNhac> {
    Context context;
    ArrayList<listNhac> arrayList;
    int layoutResource;

    public CustomAdapterListSong(Context context, int resource, ArrayList<listNhac> arrayList) {
        super(context, resource, arrayList);
        this.context = context;
        this.layoutResource = resource;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResource, null);

        ImageView img = (ImageView) convertView.findViewById(R.id.imgAvatatr);
        TextView tenBaiHat = (TextView) convertView.findViewById(R.id.tenbaihat);
        TextView tenCaSi = (TextView) convertView.findViewById(R.id.tacgia);

        img.setImageResource(arrayList.get(position).getImg());
        tenBaiHat.setText(arrayList.get(position).getTenBaiHat());
        tenCaSi.setText(arrayList.get(position).getTencasi());

        return convertView;
    }

    @Nullable
    @Override
    public listNhac getItem(int position) {
        return super.getItem(position);
    }
}
