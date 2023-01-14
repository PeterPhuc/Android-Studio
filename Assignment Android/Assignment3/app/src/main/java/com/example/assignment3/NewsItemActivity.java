package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsItemActivity extends AppCompatActivity {

    ListView listView;
    NewsAdapter newsAdapter;
    ArrayList<News> newsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item);

        Intent i = getIntent();

        listView = findViewById(R.id.listViewMain);
        newsArrayList = new ArrayList<News>();

        runOnUiThread(new Runnable() {        //thực thi ReadData
            @Override
            public void run() {
                new ReadData().execute(i.getStringExtra("url"));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( NewsItemActivity.this, ReadNewsActivity.class);
                intent.putExtra("link", newsArrayList.get(position).link);
                startActivity(intent);
            }
        });

    }

    class ReadData extends AsyncTask<String, Integer, String> {  //lớp đọc data

        @Override
        protected void onPostExecute(String s) {          //Hàm chạy sau cùng sau khi doInBackground end, lấy data từ doInbackground
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);           //đưa string đọc được vào biến document
            NodeList nodeList = document.getElementsByTagName("item");
            NodeList nodeListDescription = document.getElementsByTagName("description");

            String imgUrls = "";
            String titles = "";
            String links = "";
            for (int i=0 ; i < nodeList.getLength() ; i++){         //Duyệt qua notelist chứa các thẻ item
                String cdata = nodeListDescription.item(i + 1).getTextContent();               //lấy content của thẻ CDATA trong thẻ description, lưu ý bỏ đi thằng description đầu tiên

                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher = p.matcher(cdata);
                if ( matcher.find()){
                    imgUrls = matcher.group(1);  //group return match string
                }

                Element element = (Element) nodeList.item(i);                 //Lấy ra item trong nodelist
                titles = parser.getValue(element, "title");
                links = parser.getValue(element, "link");
                newsArrayList.add(new News( links, imgUrls, titles));
            }
            newsAdapter = new NewsAdapter(NewsItemActivity.this, android.R.layout.activity_list_item, newsArrayList);  
            listView.setAdapter(newsAdapter);
            super.onPostExecute(s);
//            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        private String docNoiDung_Tu_URL(String theUrl){
            StringBuilder content = new StringBuilder();
            try {

                URL url = new URL(theUrl);   //Tạo đối tượng url

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));  //Mở kết nối url và đọc nội dung trong url

                String line;
                while ((line = bufferedReader.readLine()) != null){  //Vòng lặp đọc line
                    content.append(line + "\n");
                }
                bufferedReader.close();
            }
            catch(Exception e)    {
                e.printStackTrace();  //Báo lỗi nếu ko thể đọc file
            }

            return content.toString();
        }
    }
}