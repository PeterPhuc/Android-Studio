package com.example.listviewcustom;

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

public class CustomAdapter extends ArrayAdapter<Country> {
    Context context;
    ArrayList<Country> arrayList;
    int layoutResource;

    public CustomAdapter(Context context, int resource, ArrayList<Country> arrayList) {
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

        ImageView img = (ImageView) convertView.findViewById(R.id.img_flag);
        TextView tenQuocGia = (TextView) convertView.findViewById(R.id.tenquocgia);
        TextView danso = (TextView) convertView.findViewById(R.id.danso);

        img.setImageResource(arrayList.get(position).getImg());
        tenQuocGia.setText(arrayList.get(position).getName());
        danso.setText(arrayList.get(position).getDanso());

        return convertView;
    }

    @Nullable
    @Override
    public Country getItem(int position) {   //Khi nhấn vào mỗi item thì lấy ra item tương ứng đó, là bài hát tương ứng
        return super.getItem(position);
    }
}
