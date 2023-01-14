package com.example.liviewproduct;

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

public class CustomAdapter extends ArrayAdapter<product> {
    Context context;
    ArrayList<product> arrayList;
    int layoutResource;

    public CustomAdapter(Context context, int resource, ArrayList<product> arrayList) {
        super(context, resource, arrayList);
        this.context = context;
        this.layoutResource = resource;
        this.arrayList = arrayList;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResource, null);

        ImageView img = (ImageView) convertView.findViewById(R.id.imgProduct);
        TextView tenSp = (TextView) convertView.findViewById(R.id.tensp);
        TextView giaSp = (TextView) convertView.findViewById(R.id.giasp);
        TextView donGia = (TextView) convertView.findViewById(R.id.dongia);

        img.setImageResource(arrayList.get(position).getImg());
        tenSp.setText(arrayList.get(position).getTensp());
        giaSp.setText(arrayList.get(position).getGiatien());
        donGia.setText(arrayList.get(position).getDongia());

        ImageView topArrow = (ImageView) convertView.findViewById(R.id.nutTang);
        ImageView botArrow = (ImageView) convertView.findViewById(R.id.nutGiam);
        TextView sl = (TextView) convertView.findViewById(R.id.soluong);
        topArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(sl.getText().toString());
                if(num >= 0) {

                    String getdongia = donGia.getText().toString();
                    int numdongia = Integer.parseInt(getdongia.split("\\.")[0]);

                    String getgiasp = giaSp.getText().toString();
                    int numgiasp = Integer.parseInt(getgiasp.split("\\.")[0]) + numdongia;

                    sl.setText(String.valueOf(num + 1));
                    giaSp.setText(String.valueOf(numgiasp + ".000đ"));
                }
            }
        });

        botArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(sl.getText().toString());
                if(num > 0) {

                    String getdongia = donGia.getText().toString();
                    int numdongia = Integer.parseInt(getdongia.split("\\.")[0]);

                    String getgiasp = giaSp.getText().toString();
                    int numgiasp = Integer.parseInt(getgiasp.split("\\.")[0]) - numdongia;

                    sl.setText(String.valueOf(num - 1));
                    giaSp.setText(String.valueOf(numgiasp + ".000đ"));
                }
            }
        });

        return convertView;
    }

    @Nullable
    @Override
    public product getItem(int position) {   //Khi nhấn vào mỗi item thì lấy ra item tương ứng đó, là bài hát tương ứng
        return super.getItem(position);
    }
}
