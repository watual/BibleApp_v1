package com.example.bibleapp_v1;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessageSender_text extends AppCompatActivity {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    public static int ITEMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_sender_text);
        get_bibleData();
    }
    //성경 텍스트 가져오기
    private void get_bibleData() {
        AssetManager am = getResources().getAssets();
        InputStream is = null;

        try {
            is = am.open("test4.txt");

            BufferedReader bufrd = new BufferedReader(new InputStreamReader(is));

            String line = "";
            while((line = bufrd.readLine()) != null){
                if(line.indexOf(MainActivity.bibleParagraph[0])==0){
                    make_textView(line);
                    make_textView("");
                }
            }

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void make_textView(String str) {
        LinearLayout container = (LinearLayout) findViewById(R.id.message_sender_text_scrollview);
        //TextView 생성
        TextView view = new TextView(this);
        view.setText(str);
        view.setTextSize(20);
        view.setTextColor(Color.BLACK);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.LEFT;
        view.setLayoutParams(lp);
        //뷰 추가
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.messageToSend = str;
                go_MessageSender_send(v);
            }
        });

    }
    public void go_MessageSender_send(View v) {
        Intent intent = new Intent(MessageSender_text.this , MessageSender_send.class);
        startActivity(intent);
    }
}
