package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(@NonNull Context context, int resource, @NonNull List<News> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.activity_news_details, null);
        }
        News news = getItem(position);
        if (news != null) {
            // Anh xa + Gan gia tri
            TextView txt = (TextView) view.findViewById(R.id.news_title);
            txt.setText(news.title);

            ImageView imgView = (ImageView) view.findViewById(R.id.news_img);
            Picasso.with(getContext()).load(news.img).into(imgView);
        }
        return view;
    }
}
