package com.example.customlistview;

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

public class CustomViewAdapter extends ArrayAdapter<infoBaiHat> {
    Context context;
    ArrayList<infoBaiHat> arrayList;
    int layoutResource;

//Khởi tạo
    public CustomViewAdapter(Context context, int resource, ArrayList<infoBaiHat> arrayList) {
        super(context, resource, arrayList);
        this.context = context;
        this.layoutResource = resource;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override   //Mẹo: phải chuột nhấn generate, nhấn getView là ra
//Hàm này khởi tạo cho các dòng để hiển thị trên ListView của file activity_main.xml
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResource, null);

        ImageView img = (ImageView) convertView.findViewById(R.id.imgAvatatr);
        TextView tenBaiHat = (TextView) convertView.findViewById(R.id.tenbaihat);
        TextView tenCaSi = (TextView) convertView.findViewById(R.id.tacgia);
        TextView thoiLuong = (TextView) convertView.findViewById(R.id.time);

        img.setImageResource(arrayList.get(position).getImg());
        tenBaiHat.setText(arrayList.get(position).getNameSong());
        tenCaSi.setText(arrayList.get(position).getSinger());
        thoiLuong.setText(arrayList.get(position).getTimeSong());

        return convertView;
    }



    @Nullable
    @Override
    public infoBaiHat getItem(int position) {   //Khi nhấn vào mỗi item thì lấy ra item tương ứng đó, là bài hát tương ứng
        return super.getItem(position);
    }
}
