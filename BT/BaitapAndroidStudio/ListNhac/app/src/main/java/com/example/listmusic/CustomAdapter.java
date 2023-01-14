package com.example.listmusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Singer> {
    Context context;
    ArrayList<Singer> arrayList;
    int layoutResource;

    public CustomAdapter(Context context, int resource, ArrayList<Singer> arrayList) {
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
        TextView tenCaSi = (TextView) convertView.findViewById(R.id.tacgia);
        TextView luotCare = (TextView) convertView.findViewById(R.id.luotlike);

        img.setImageResource(arrayList.get(position).getImg());
        tenCaSi.setText(arrayList.get(position).getName());
        luotCare.setText(arrayList.get(position).getLuotCare());

        Toast.makeText(this.context, "nssnnsknsvkna", Toast.LENGTH_SHORT).show();

        return convertView;
    }

    @Nullable
    @Override
    public Singer getItem(int position) {
        return super.getItem(position);
    }
}
