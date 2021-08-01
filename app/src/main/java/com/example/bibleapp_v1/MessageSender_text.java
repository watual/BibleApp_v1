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

        //viewPager
        mPager = findViewById(R.id.message_sender_text_viewP);
        //Adapter
        int jang = 0;
        for(int i=0;i<MainActivity.bibleList.length;i++){
            if(MainActivity.bibleList[i] == MainActivity.bibleParagraph[0]) {
                jang = MainActivity.bible_Jang[i];
            }
        }
        pagerAdapter = new MyAdapter(this, jang);  //count는 장의 갯수를 입력해줘야함
        mPager.setAdapter(pagerAdapter);
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mPager.setCurrentItem(1);       //viewpage 개수 중 현재 위치
        mPager.setOffscreenPageLimit(20);    //미리 로딩하는 앞뒤 페이지 수(default: 1)

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
        MainActivity.bibleParagraph[1] = "1";   //MyAdapter 작업이 끝난 시점에 fragment에서 올린 장수 초기화
    }
    public void pageManage(int nowPage) {
        LinearLayout container = findViewById(R.id.message_sender_text_linearlayout);
        int messageSender_text_page_howMuch = 5;
        for(int i=-(messageSender_text_page_howMuch/2);i<messageSender_text_page_howMuch/2;i++){
            int n=0;
            if(nowPage-i < 1){
                n = 1-(nowPage-2);
            }
        }

        TextView textV = new TextView(this);
        textV.setText(nowPage);
        textV.setTextSize(12);
        textV.setTextColor(Color.BLACK);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.LEFT;
        textV.setLayoutParams(lp);
        //뷰 추가
        container.addView(textV);

    }
}
