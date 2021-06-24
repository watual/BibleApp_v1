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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessageSender_text extends AppCompatActivity {

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
                if(line.indexOf("창")==0){
                    make_textView(line);
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
        TextView view1 = new TextView(this);
        view1.setText(str);
        view1.setTextSize(14);
        view1.setTextColor(Color.BLACK);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.LEFT;
        view1.setLayoutParams(lp);
        //뷰 추가
        container.addView(view1);

    }
    public void go_MessageSender_send(View v) {
        Intent intent = new Intent(MessageSender_text.this , MessageSender_send.class);
        startActivity(intent);
    }
}
