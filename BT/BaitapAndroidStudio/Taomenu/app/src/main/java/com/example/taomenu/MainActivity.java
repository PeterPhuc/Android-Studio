package com.example.taomenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowPopUp = (Button) findViewById(R.id.btnShowPopUp);
        btnShowPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_comedy:
                                Toast.makeText(MainActivity.this, "Comedy Clicked", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item_movies:
                                Toast.makeText(MainActivity.this, "Movies Clicked", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.show();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.mymenu, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.item:
//                CustomDialog.FullNameListener listener = new CustomDialog.FullNameListener() {
//                    @Override
//                    public void fullNameEntered() {
//                        Intent momaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.MoMA.org"));
//                        startActivity(momaIntent);
//                    }
//                };
//                final CustomDialog dialog = new CustomDialog(this, listener);
//                dialog.show();
//                 break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    public boolean onCreateOptionsMenu(Menu menu){
        int itemId = 1000;
        menu.add(0, itemId, 0, "Thể Thao");

        SubMenu sub3 = menu.addSubMenu(0, -1, 2, "Danh mục Tin Tức");
        itemId = 1001;
        sub3.add(0, itemId, 0, "VNExpress");
        itemId = 1002;
        sub3.add(0, itemId, 1, "ZING");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1000:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://ithethao.vn")));
                break;
            case 1001:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://vnexpress.net/")));
                break;
            case 1002:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://zingnews.vn/")));
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}